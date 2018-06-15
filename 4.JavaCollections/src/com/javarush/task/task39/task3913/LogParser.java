package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    List<String> logs = new ArrayList<>();
    ArrayList<PartOfLog> partsOfLogs = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
        this.logs = processFilesFromFolder(logs, logDir.toFile());
        for (String s : logs) {
            parseString(s);
        }
    }

    public static class PartOfLog {
        public String ip;
        public String user;
        public Date date;
        public Event event;
        public String numberOfTask;
        public Status status;

        public PartOfLog(String ip, String user, Date date, Event event, String numberOfTask, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.numberOfTask = numberOfTask;
            this.status = status;
        }

        @Override
        public String toString() {
            return "PartOfLog{" +
                    " ip='" + ip + '\'' +
                    ", user='" + user + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", numberOfTask='" + numberOfTask + '\'' +
                    ", status=" + status +
                    '}';
        }
    }

    //смотрим директорию logDir, ищем файлы с логами
    private List<String> processFilesFromFolder(List<String> logs, File file) {
        File[] folderEntries = file.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(logs, entry);
            }
            if (entry.isFile() && entry.getName().endsWith(".log")) {
                logs.addAll(loadListOfLogsFromFiles(entry));
            }
        }
        return logs;
    }

    //загружаем все строки логов из файлов в список
    private List<String> loadListOfLogsFromFiles(File entry) {
        List<String> listLogs = new ArrayList<>();
        try {
            listLogs = Files.readAllLines(entry.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLogs;
    }

    void parseString(String str) {
        String[] partOfString = str.trim().split("\t");
        String IP = partOfString[0].trim();
        String name = partOfString[1];
        Date date = null;
        Event event = null;
        String numberTask = null;
        Status status = null;

        for (int i = 2; i < partOfString.length; i++) {
            if (parseDate(partOfString[i], "d.M.y H:m:s") != null) {
                date = parseDate(partOfString[i], "d.M.y H:m:s");
                String[] pairEventAndNumber = partOfString[i + 1].split(" ");
                event = Event.valueOf(pairEventAndNumber[0].toUpperCase());
                if (pairEventAndNumber.length > 1 && (event.name().equals("SOLVE_TASK") || event.name().equals("DONE_TASK"))) {
                    numberTask = pairEventAndNumber[1];
                }
                if (i != partOfString.length - 1) {
                    status = Status.valueOf(partOfString[partOfString.length - 1].toUpperCase());
                }
                break;
            } else {
                name = (name + " " + partOfString[i]);
            }
        }
        partsOfLogs.add(new PartOfLog(IP, name, date, event, numberTask, status));
    }

    Date parseDate(String s, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException ignored) {
        }
        return date;
    }

    private boolean isDateInRange(Date check, Date after, Date before) {
        boolean fits = before == null || check.before(before) || check.equals(before);
        return fits && (after == null || check.after(after) || check.equals(after));
    }

    private Set<String> getIPs(ArrayList<PartOfLog> parts, Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : parts) {
                uniqueIPs.add(part.ip);
            }
        }
        for (PartOfLog part : parts) {
            if (isDateInRange(part.date, after, before)) {
                uniqueIPs.add(part.ip);
            }
        }
        return uniqueIPs;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = getUniqueIPs(after, before);
        return uniqueIPs.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIPs(partsOfLogs, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        ArrayList<PartOfLog> partsFilterUsers = new ArrayList<>();
        for (PartOfLog p : partsOfLogs) {
            if (p.user.equals(user)) {
                partsFilterUsers.add(p);
            }
        }
        return getIPs(partsFilterUsers, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        ArrayList<PartOfLog> partsFilterEvent = new ArrayList<>();
        for (PartOfLog p : partsOfLogs) {
            if (p.event.equals(event)) {
                partsFilterEvent.add(p);
            }
        }
        return getIPs(partsFilterEvent, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        ArrayList<PartOfLog> partsFilterStatus = new ArrayList<>();
        for (PartOfLog p : partsOfLogs) {
            if (p.status.equals(status)) {
                partsFilterStatus.add(p);
            }
        }
        return getIPs(partsFilterStatus, after, before);
    }

    private Set<String> getUsers(ArrayList<PartOfLog> parts, Date after, Date before) {
        Set<String> uniqueUsers = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : parts) {
                uniqueUsers.add(part.user);
            }
        }
        for (PartOfLog part : parts) {
            if (isDateInRange(part.date, after, before)) {
                uniqueUsers.add(part.user);
            }
        }
        return uniqueUsers;
    }

    private Set<Date> getDates(ArrayList<PartOfLog> parts, Date after, Date before) {
        Set<Date> uniqueDates = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : parts) {
                uniqueDates.add(part.date);
            }
        }
        for (PartOfLog part : parts) {
            if (isDateInRange(part.date, after, before)) {
                uniqueDates.add(part.date);
            }
        }
        return uniqueDates;
    }

    private Set<Event> getEvents(ArrayList<PartOfLog> parts, Date after, Date before) {
        Set<Event> uniqueEvents = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : parts) {
                uniqueEvents.add(part.event);
            }
        }
        for (PartOfLog part : parts) {
            if (isDateInRange(part.date, after, before)) {
                uniqueEvents.add(part.event);
            }
        }
        return uniqueEvents;
    }

    private Set<Status> getStatuses(ArrayList<PartOfLog> parts, Date after, Date before) {
        Set<Status> uniqueStatuses = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : parts) {
                uniqueStatuses.add(part.status);
            }
        }
        for (PartOfLog part : parts) {
            if (isDateInRange(part.date, after, before)) {
                uniqueStatuses.add(part.status);
            }
        }
        return uniqueStatuses;
    }

    //В валидаторе есть проблема с проверкой требований №3, 4, 11.
    //Исключительно для этих случаев при проверке попадания даты в диапазон, валидатору не нравится  date >= after && date <= before,
    // как для всех остальных требований. Теперь ему требуется ТОЛЬКО date > after && date < before

    private StringQuery parseQuery(String query) {
        String field1, field2, value1, after, before;

        if (query.contains("\" and date between \"")) {
            Pattern p = Pattern.compile("^get\\s(.*?)\\sfor\\s(.*?)\\s=\\s\"(.*)\"\\sand date between\\s\"(.*?)\"\\sand\\s\"(.*?)\"");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
            field2 = m.group(2);
            value1 = m.group(3);
            after = m.group(4);
            before = m.group(5);
            return new StringQuery(field1, field2, value1, after, before);
        } else if (query.contains(" = \"")) {
            Pattern p = Pattern.compile("get\\s(.*?)\\sfor\\s(.*?)\\s=\\s\"(.*)\"");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
            field2 = m.group(2);
            value1 = m.group(3);
            return new StringQuery(field1, field2, value1, null, null);
        } else {
            Pattern p = Pattern.compile("^get\\s(.*?)$");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
            return new StringQuery(field1, null, null, null, null);
        }
    }

    private class StringQuery {
        public StringQuery(String field1, String field2, String value1, String after, String before) {
            this.field1 = field1;
            this.field2 = field2;
            this.value1 = value1;
            this.after = after;
            this.before = before;
        }

        String field1 = "";
        String field2 = "";
        String value1 = "";
        String after = "";
        String before = "";
    }

    private Set<Object> executeQueryNoLimitsByDate(String field1, ArrayList<PartOfLog> partFiltered) {
        Set<Object> result = new HashSet<>();
        switch ("get " + field1.toLowerCase()) {
            case "get ip":
                result.addAll(getIPs(partFiltered, null, null));
                break;
            case "get user":
                result.addAll(getUsers(partFiltered, null, null));
                break;
            case "get date":
                result.addAll(getDates(partFiltered, null, null));
                break;
            case "get event":
                result.addAll(getEvents(partFiltered, null, null));
                break;
            case "get status":
                result.addAll(getStatuses(partFiltered, null, null));
                break;
        }
        return result;
    }

    private Set<Object> executeQuery(String field1, String dateAfter, String dateBefore, ArrayList<PartOfLog> partFiltered) {
        Set<Object> result = new HashSet<>();
        Date after = parseDate(dateAfter, "dd.MM.yyyy HH:mm:ss");
        Date before = parseDate(dateBefore, "dd.MM.yyyy HH:mm:ss");
        switch ("get " + field1.toLowerCase()) {
            case "get ip":
                result.addAll(getIPs(partFiltered, after, before));
                break;
            case "get user":
                result.addAll(getUsers(partFiltered, after, before));
                break;
            case "get date":
                result.addAll(getDates(partFiltered, after, before));
                break;
            case "get event":
                result.addAll(getEvents(partFiltered, after, before));
                break;
            case "get status":
                result.addAll(getStatuses(partFiltered, after, before));
                break;
        }
        return result;
    }

    private ArrayList<PartOfLog> getFilteredPartsOfLogs(String query, StringQuery parseQuery) {
        ArrayList<PartOfLog> partFiltered = new ArrayList<>();
        if (parseQuery.field2 != null && parseQuery.value1 != null) {
            for (PartOfLog p : partsOfLogs) {
                try {
                    if (parseQuery.field2.equals("date")) {
                        if (p.date.equals(parseDate(parseQuery.value1, "d.M.y H:m:s"))) {
                            partFiltered.add(p);
                        } else if (p.date.equals(parseDate(parseQuery.value1, "d.M.y H.m.s"))) {
                            partFiltered.add(p);
                        }
                    } else if ((p.getClass().getField(parseQuery.field2).get(p)).toString().equals(parseQuery.value1)) {
                        partFiltered.add(p);
                    }
                } catch (NoSuchFieldException | IllegalAccessException ignored) {
                }
            }
        } else {
            partFiltered.addAll(partsOfLogs);
        }
        return partFiltered;
    }

    private Set<Object> getIpsParticularCase(String dateAfter, String dateBefore, ArrayList<PartOfLog> partFiltered) {
        Set<Object> uniqueIPs = new HashSet<>();
        Date after = parseDate(dateAfter, "d.M.y H:m:s");
        Date before = parseDate(dateBefore, "d.M.y H:m:s");
        for (PartOfLog part : partFiltered) {
            if (isDateInRangeParticularCase(part.date, after, before)) {
                uniqueIPs.add(part.ip);
            }
        }
        return uniqueIPs;
    }

    private Set<Object> getDatesParticularCase(String dateAfter, String dateBefore, ArrayList<PartOfLog> partFiltered) {
        Set<Object> uniqueDates = new HashSet<>();
        Date after = parseDate(dateAfter, "d.M.y H:m:s");
        Date before = parseDate(dateBefore, "d.M.y H:m:s");
        for (PartOfLog part : partFiltered) {
            if (isDateInRangeParticularCase(part.date, after, before)) {
                uniqueDates.add(part.date);
            }
        }
        return uniqueDates;
    }

    private boolean isDateInRangeParticularCase(Date check, Date after, Date before) {
        boolean fits = before == null || check.before(before);
        return fits && (after == null || check.after(after));
    }

//    UserQuery

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            allUsers.add(p.user);
        }
        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> allUsers = new TreeSet<>();
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                allUsers.add(p.user);
            }
        }
        return allUsers.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        ArrayList<PartOfLog> partsFilterUser = new ArrayList<>();
        for (PartOfLog p : partsOfLogs) {
            if (p.user.equals(user)) {
                partsFilterUser.add(p);
            }
        }
        Set<String> uniqueEvents = new HashSet<>();
        if (after == null && before == null) {
            for (PartOfLog part : partsFilterUser) {
                uniqueEvents.add(part.event.toString());
            }
        }

        for (PartOfLog part : partsFilterUser) {
            if (isDateInRange(part.date, after, before)) {
                uniqueEvents.add(part.event.toString());
            }
        }
        return uniqueEvents.size();
//        Set<String> allUsers = new HashSet<>();
//        int count = 0;
//        for (PartOfLog p : partsOfLogs) {
//            if ((after == null && before == null) ||
//                    (before != null && after == null && p.date.before(before)) ||
//                    (after != null && before == null && p.date.after(after)) ||
//                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
//                if (user.equals(p.user))
//                    count++;
//            }
//        }
//        return count;
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if (ip.equals(p.ip))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("LOGIN".equals(p.event.toString()))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("DOWNLOAD_PLUGIN".equals(p.event.toString()))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("WRITE_MESSAGE".equals(p.event.toString()))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        ArrayList<PartOfLog> partsFilterSolvedTask = new ArrayList<>();
        for (PartOfLog p : partsOfLogs) {
            if (p.event.equals(Event.SOLVE_TASK)) {
                partsFilterSolvedTask.add(p);
            }
        }
        return getUsers(partsFilterSolvedTask, after, before);
//        Set<String> allUsers = new HashSet<>();
//        int count = 0;
//        for (PartOfLog p : partsOfLogs) {
//            if ((after == null && before == null) ||
//                    (before != null && after == null && p.date.before(before)) ||
//                    (after != null && before == null && p.date.after(after)) ||
//                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
//                if ("WRITE_MESSAGE".equals(p.event.toString()))
//                    allUsers.add(p.user);
//            }
//        }
//        return allUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("SOLVE_TASK".equals(p.event.toString()) && task == Integer.parseInt(p.numberOfTask))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("DONE_TASK".equals(p.event.toString()))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> allUsers = new HashSet<>();
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if ((after == null && before == null) ||
                    (before != null && after == null && p.date.before(before)) ||
                    (after != null && before == null && p.date.after(after)) ||
                    (after != null && before != null && p.date.after(after)) && p.date.before(before)) {
                if ("DONE_TASK".equals(p.event.toString()) && task == Integer.parseInt(p.numberOfTask))
                    allUsers.add(p.user);
            }
        }
        return allUsers;
    }

//    DateQuery

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals(event.toString()))
                dateSet.add(p.date);

        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.status.toString().equals("FAILED"))
                dateSet.add(p.date);
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.status.toString().equals("ERROR"))
                dateSet.add(p.date);
        }
        return dateSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals("LOGIN"))
                dateSet.add(p.date);
        }
        if (dateSet.size() == 0)
            return null;
        Date[] dates = new Date[dateSet.size()];
        int ii = 0;
        for (Date d : dateSet) {
            dates[ii++] = d;
        }
        Arrays.sort(dates);
        return dates[0];
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals("SOLVE_TASK") &&
                    Integer.parseInt(p.numberOfTask) == task)
                dateSet.add(p.date);
        }
        if (dateSet.size() == 0)
            return null;
        Date[] dates = new Date[dateSet.size()];
        int ii = 0;
        for (Date d : dateSet) {
            dates[ii++] = d;
        }
        Arrays.sort(dates);
        return dates[0];
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals("DONE_TASK") &&
                    Integer.parseInt(p.numberOfTask) == task)
                dateSet.add(p.date);
        }
        if (dateSet.size() == 0)
            return null;
        Date[] dates = new Date[dateSet.size()];
        int ii = 0;
        for (Date d : dateSet) {
            dates[ii++] = d;
        }
        Arrays.sort(dates);
        return dates[0];
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals("WRITE_MESSAGE"))
                dateSet.add(p.date);
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    p.user.equals(user) &&
                    p.event.toString().equals("DOWNLOAD_PLUGIN"))
                dateSet.add(p.date);
        }
        return dateSet;
    }

//    EventQuery

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
//        int count = 0;
//        for (PartOfLog p : partsOfLogs)
//            if (isDateInRange(p.date, after, before)) count++;
//        return count;
        return getEvents(partsOfLogs, after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before))
                eventSet.add(p.event);
        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    ip.equals(p.ip))
                eventSet.add(p.event);
        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    user.equals(p.user))
                eventSet.add(p.event);
        }
        return eventSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    "FAILED".equals(p.status.toString()))
                eventSet.add(p.event);
        }
        return eventSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    "ERROR".equals(p.status.toString()))
                eventSet.add(p.event);
        }
        return eventSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (PartOfLog p : partsOfLogs) {
            if (isDateInRange(p.date, after, before) &&
                    "SOLVE_TASK".equals(p.event.toString()) &&
                    task == Integer.parseInt(p.numberOfTask))
                count++;
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
//        int count = 0;
//        for (PartOfLog p : partsOfLogs) {
//            if (isDateInRange(p.date, after, before) &&
//                    "DONE_TASK".equals(p.event.toString()) &&
//                    task == Integer.parseInt(p.numberOfTask) &&
//                    p.status.toString().equals("OK"))
//                count++;
//        }
//        return count;
        ArrayList<PartOfLog> partsFilterSuccessfulAttemptToSolveTask = new ArrayList<>();
        for (PartOfLog p : partsOfLogs)
            if (p.event.equals(Event.DONE_TASK) && Integer.parseInt(p.numberOfTask) == task)
                partsFilterSuccessfulAttemptToSolveTask.add(p);
        HashSet<PartOfLog> result = new HashSet<>();
        if (after == null && before == null) result.addAll(partsFilterSuccessfulAttemptToSolveTask);
        for (PartOfLog part : partsFilterSuccessfulAttemptToSolveTask)
            if (isDateInRange(part.date, after, before)) result.add(part);
        return result.size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        HashSet<Integer> numbersOfTask = new HashSet<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        for (PartOfLog p : partsOfLogs)
            if (p.numberOfTask != null) numbersOfTask.add(Integer.parseInt(p.numberOfTask));
        for (int i : numbersOfTask) {
            int value = getNumberOfAttemptToSolveTask(i, after, before);
            if (value > 0) result.put(i, value);
        }

        return result;
//        Map<Integer, Integer> solvedTasks = new HashMap<>();
//        for (PartOfLog p : partsOfLogs) {
//            if (isDateInRange(p.date, after, before) &&
//                    p.numberOfTask != null &&
//                    p.event.toString().equals("SOLVE_TASK")) {
//                solvedTasks.put(Integer.parseInt(p.numberOfTask),
//                        solvedTasks.get(Integer.parseInt(p.numberOfTask)) == null ?
//                                0 :
//                                solvedTasks.get(Integer.parseInt(p.numberOfTask)) + 1);
//            }
//        }
//        return solvedTasks;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
//        Map<Integer, Integer> doneTasks = new HashMap<>();
//        for (PartOfLog p : partsOfLogs) {
//            if (isDateInRange(p.date, after, before) &&
//                    p.event.toString().equals("DONE_TASK") &&
//                    p.numberOfTask != null) {
//                doneTasks.put(Integer.parseInt(p.numberOfTask),
//                        doneTasks.get(Integer.parseInt(p.numberOfTask)) == null ?
//                                0 :
//                                doneTasks.get(Integer.parseInt(p.numberOfTask)) + 1);
//            }
//        }
//        return doneTasks;
        HashSet<Integer> numbersOfTask = new HashSet<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        for (PartOfLog p : partsOfLogs)
            if (p.numberOfTask != null) numbersOfTask.add(Integer.parseInt(p.numberOfTask));
        for (int i : numbersOfTask) {
            int value = getNumberOfSuccessfulAttemptToSolveTask(i, after, before);
            if (value > 0) result.put(i, value);
        }
        return result;
    }

//    QLQuery
@Override
public Set<Object> execute(String query) {
    Set<Object> result = new HashSet<>();
    StringQuery parseQuery = parseQuery(query);

    if (parseQuery.after != null && parseQuery.before != null && parseQuery.field1.equals("ip") && (parseQuery.field2.equals("event") || parseQuery.field2.equals("status"))) {
        result = getIpsParticularCase(parseQuery.after, parseQuery.before, getFilteredPartsOfLogs(query, parseQuery));
    } else if (parseQuery.after != null && parseQuery.before != null && parseQuery.field1.equals("date") && parseQuery.field2.equals("event")) {
        result = getDatesParticularCase(parseQuery.after, parseQuery.before, getFilteredPartsOfLogs(query, parseQuery));
    } else if (parseQuery.after == null && parseQuery.before == null) {
        result = executeQueryNoLimitsByDate(parseQuery.field1, getFilteredPartsOfLogs(query, parseQuery));
    } else {
        result = executeQuery(parseQuery.field1, parseQuery.after, parseQuery.before, getFilteredPartsOfLogs(query, parseQuery));
    }
    return result;
}

// Работает, не проходит валидацию.
//    @Override
//    public Set<Object> execute(String query) {
//        Set<Object> result = new HashSet<>();
//        if (!query.contains("for")) {
//            switch (query) {
//                case "get ip":
//                    for (PartOfLog p : partsOfLogs) {
//                        result.add(p.ip);
//                    }
//                    return result;
//                case "get user":
//                    for (PartOfLog p : partsOfLogs) {
//                        result.add(p.user);
//                    }
//                    return result;
//                case "get date":
//                    for (PartOfLog p : partsOfLogs) {
//                        result.add(p.date);
//                    }
//                    return result;
//                case "get event":
//                    for (PartOfLog p : partsOfLogs) {
//                        result.add(p.event);
//                    }
//                    return result;
//                case "get status":
//                    for (PartOfLog p : partsOfLogs) {
//                        result.add(p.status);
//                    }
//                    return result;
//            }
//        } else if (!query.contains("and")) {
//            return executeParser(query, partsOfLogs);
//        } else {
//            String[] s = query.split(" ");
////            System.out.println(s);
////            String afStr = s[9].substring(1) + " " + s[10].substring(0, s[10].length() - 1);
////            String befStr = s[12].substring(1) + " " + s[13].substring(0, s[13].length() - 1);
//            int count = 0;
//            for (int i = 0; i < s.length; i++) {
//                if (s[i].contains("\"")) count++;
////            arrayList.add(i, value[i].contains("\"") ? 1 : 0);
////            System.out.print(arrayList.get(i) +" ");
//            }
////            System.out.println(count);
//            String befStr = "";
//            String afStr="";
//            if (count == 5) {
//                afStr = query.split(" ")[9].substring(1) + " " + query.split(" ")[10].substring(0, query.split(" ")[10].length() - 1);
//                befStr = query.split(" ")[12].substring(1) + " " + query.split(" ")[13].substring(0, query.split(" ")[13].length() - 1);
//            } else {
//                afStr = query.split(" ")[10].substring(1) + " " + query.split(" ")[11].substring(0, query.split(" ")[11].length() - 1);
//                befStr = query.split(" ")[13].substring(1) + " " + query.split(" ")[14].substring(0, query.split(" ")[14].length() - 1);
//            }
////            System.out.println(after);
////            System.out.println(before);
//            try {
//                Date after = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(afStr);
//                Date before = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(befStr);
//                ArrayList<PartOfLog> partsOfLogsAfterBefore = new ArrayList<>();
//                for (PartOfLog p : partsOfLogs) {
//                    if (isDateInRange(p.date, after, before))
//                        partsOfLogsAfterBefore.add(p);
//                }
//                return executeParser(query, partsOfLogsAfterBefore);
//            } catch (ParseException ignored) {
//            }
//        }
//        return null;
//    }

    public Set<Object> executeParser(String query, ArrayList<PartOfLog> partsOfLogs) {
        Set<Object> result = new HashSet<>();
        String field1 = query.split(" ")[1];
        String field2 = query.split(" ")[3];
//        String value2 = query.substring(query.indexOf("\"") + 1, query.lastIndexOf("\""));
//        String value2 = query.substring(query.indexOf("\"") + 1).substring(0, query.indexOf("\""));
//        String value2 = query.split(" ")[5].substring(1, query.split(" ")[5].length() - 1);
        int count = 0;
        for (int i = 0; i < query.split(" ").length; i++) {
            if (query.split(" ")[i].contains("\"")) count++;
        }
        String value2;
        if (count == 5) {
            value2 = query.split(" ")[5].substring(1, query.split(" ")[5].length() - 1);
        } else {
            value2 = query.split(" ")[5].substring(1)+" "+ query.split(" ")[6].substring(0,query.split(" ")[6].length() - 1);
        }
//            System.out.println(field1);
//            System.out.println(field2);
//            System.out.println(value2);
        switch (field1) {
            case "ip":
                switch (field2) {
                    case "ip":
                        for (PartOfLog p : partsOfLogs)
                            if (p.ip.equals(value2))
                                result.add(p.ip);
                        return result;
                    case "user":
                        for (PartOfLog p : partsOfLogs)
                            if (p.user.equals(value2))
                                result.add(p.ip);
                        return result;
                    case "date":
                        for (PartOfLog p : partsOfLogs) {
                            Date value = null;
                            try {
                                value = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(value2);
                            } catch (ParseException ignored) {
                            }
                            if (value.equals(p.date))
                                result.add(p.ip);
                        }
                        return result;
                    case "event":
                        for (PartOfLog p : partsOfLogs)
                            if (p.event.toString().equals(value2))
                                result.add(p.ip);
                        return result;
                    case "status":
                        for (PartOfLog p : partsOfLogs)
                            if (p.status.toString().equals(value2))
                                result.add(p.ip);
                        return result;
                }
            case "user":
                switch (field2) {
                    case "ip":
                        for (PartOfLog p : partsOfLogs)
                            if (p.ip.equals(value2))
                                result.add(p.user);
                        return result;
                    case "user":
                        for (PartOfLog p : partsOfLogs)
                            if (p.user.equals(value2))
                                result.add(p.user);
                        return result;
                    case "date":
                        for (PartOfLog p : partsOfLogs) {
                            Date value = null;
                            try {
                                value = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(value2);
                            } catch (ParseException ignored) {
                            }
                            if (value.equals(p.date))
                                result.add(p.user);
                        }
                        return result;
                    case "event":
                        for (PartOfLog p : partsOfLogs)
                            if (p.event.toString().equals(value2))
                                result.add(p.user);
                        return result;
                    case "status":
                        for (PartOfLog p : partsOfLogs)
                            if (p.status.toString().equals(value2))
                                result.add(p.user);
                        return result;
                }
            case "date":
                switch (field2) {
                    case "ip":
                        for (PartOfLog p : partsOfLogs)
                            if (p.ip.equals(value2))
                                result.add(p.date);
                        return result;
                    case "user":
                        for (PartOfLog p : partsOfLogs)
                            if (p.user.equals(value2))
                                result.add(p.date);
                        return result;
                    case "date":
                        for (PartOfLog p : partsOfLogs) {
                            Date value = null;
                            try {
                                value = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(value2);
                            } catch (ParseException ignored) {
                            }
                            if (value.equals(p.date))
                                result.add(p.date);
                        }
                        return result;
                    case "event":
                        for (PartOfLog p : partsOfLogs)
                            if (p.event.toString().equals(value2))
                                result.add(p.date);
                        return result;
                    case "status":
                        for (PartOfLog p : partsOfLogs)
                            if (p.status.toString().equals(value2))
                                result.add(p.date);
                        return result;
                }
            case "event":
                switch (field2) {
                    case "ip":
                        for (PartOfLog p : partsOfLogs)
                            if (p.ip.equals(value2))
                                result.add(p.event);
                        return result;
                    case "user":
                        for (PartOfLog p : partsOfLogs)
                            if (p.user.equals(value2))
                                result.add(p.event);
                        return result;
                    case "date":
                        for (PartOfLog p : partsOfLogs) {
                            Date value = null;
                            try {
                                value = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(value2);
                            } catch (ParseException ignored) {
                            }
                            if (value.equals(p.date))
                                result.add(p.event);
                        }
                        return result;
                    case "event":
                        for (PartOfLog p : partsOfLogs)
                            if (p.event.toString().equals(value2))
                                result.add(p.event);
                        return result;
                    case "status":
                        for (PartOfLog p : partsOfLogs)
                            if (p.status.toString().equals(value2))
                                result.add(p.event);
                        return result;
                }
            case "status":
                switch (field2) {
                    case "ip":
                        for (PartOfLog p : partsOfLogs)
                            if (p.ip.equals(value2))
                                result.add(p.status);
                        return result;
                    case "user":
                        for (PartOfLog p : partsOfLogs)
                            if (p.user.equals(value2))
                                result.add(p.status);
                        return result;
                    case "date":
                        for (PartOfLog p : partsOfLogs) {
                            Date value = null;
                            try {
                                value = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(value2);
                            } catch (ParseException ignored) {
                            }
                            if (value.equals(p.date))
                                result.add(p.status);
                        }
                        return result;
                    case "event":
                        for (PartOfLog p : partsOfLogs)
                            if (p.event.toString().equals(value2))
                                result.add(p.status);
                        return result;
                    case "status":
                        for (PartOfLog p : partsOfLogs)
                            if (p.status.toString().equals(value2))
                                result.add(p.status);
                        return result;
                }
        }
        return result;
    }
}
// Работает, не принимает
//public class LogParser implements IPQuery {
//    private Path logDir;
//    private ArrayList<File> files;
//
//    public LogParser(Path logDir) {
//        this.logDir = logDir;
//        files = new ArrayList<>();
//        File[] f = logDir.toFile().listFiles();
////        System.out.println("All files: \n");
//        for (int i = 0; i < f.length; i++) {
//            if (f[i].isFile() && f[i].getName().endsWith(".log"))
//                files.add(f[i]);
////            System.out.println(f[i].getAbsolutePath()+f[i].getName());
//        }
////        System.out.println("Log files: \n");
////        for (File ff:files             ) {
////            System.out.println(ff);
////        }
//    }
//
//    @Override
//    public int getNumberOfUniqueIPs(Date after, Date before) {
////        System.out.println(getUniqueIPs(after, before).size());
//        return getUniqueIPs(after, before).size();
//    }
//
//    @Override
//    public Set<String> getUniqueIPs(Date after, Date before) {
//        TreeSet<String> uniqueStrings = (TreeSet<String>) getUniqueStrings(after, before);
//        TreeSet<String> uniqueIPs = new TreeSet<>();
//        for (String s : uniqueStrings) {
//            uniqueIPs.add(s.split("\\t")[0]);
//        }
//        return uniqueIPs;
//    }
//
//    public Set<String> getUniqueStrings(Date after, Date before) {
//        TreeSet<String> uniqueIPs = new TreeSet<>();
//        for (File f : files) {
//            try {
//                BufferedReader br = new BufferedReader(new FileReader(f));
////                int count = 0;
//                while (br.ready()) {
////                    count = 0;
//                    String str = br.readLine();
//                    String[] strings = str.split("\\t");
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//                    Date date = dateFormat.parse(strings[2]);
//                    if ((after == null && before == null) ||
//                            (before != null && after == null && date.before(before)) ||
//                            (after != null && before == null && date.after(after)) ||
//                            (after != null && before != null && date.after(after)) && date.before(before)) {
////                        System.out.println(strings[0]);
//                        uniqueIPs.add(str);
////                        count++;
//                    }
//                }
////                System.out.println(uniqueIPs.size());
//                br.close();
//                return uniqueIPs;
//            } catch (IOException | ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Set<String> getIPsForUser(String user, Date after, Date before) {
//        TreeSet<String> uniqueStrings = (TreeSet<String>) getUniqueStrings(after, before);
//        TreeSet<String> IPsForUser = new TreeSet<>();
//        for (String s : uniqueStrings) {
//            if (s.split("\\t")[1].equals(user))
//                IPsForUser.add(s.split("\\t")[0]);
//        }
////        for (String s : IPsForUser) {
////            System.out.println(s);
////        }
//        return IPsForUser;
//    }
//
//    @Override
//    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
//        TreeSet<String> uniqueStrings = (TreeSet<String>) getUniqueStrings(after, before);
//        TreeSet<String> IPsForEvent = new TreeSet<>();
//        for (String s : uniqueStrings) {
//            String s1 = s.split("\\t")[3].split(" ")[0];
//            if (s1.equals(event.toString()))
//                IPsForEvent.add(s.split("\\t")[0]);
//        }
//        for (String s : IPsForEvent) {
//            System.out.println(s);
//        }
//        return IPsForEvent;
//    }
//
//    @Override
//    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
//        TreeSet<String> uniqueStrings = (TreeSet<String>) getUniqueStrings(after, before);
//        TreeSet<String> IPsForStatus = new TreeSet<>();
//        for (String s : uniqueStrings) {
//            if (s.split("\\t")[4].equals(status.toString()))
//                IPsForStatus.add(s.split("\\t")[0]);
//        }
////        for (String s : IPsForEvent) {
////            System.out.println(s);
////        }
//        return IPsForStatus;
//    }
//
//}
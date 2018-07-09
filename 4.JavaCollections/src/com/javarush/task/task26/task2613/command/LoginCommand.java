package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    //            ResourceBundle.getBundle("./"+CashMachine.class.getPackage().toString().split(" ")[1].replace(".","/")+"/resources/verifiedCards.properties");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");
//    private String numberOfCard = "123456789012";
//    private String pinCode = "1234";

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String number = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();
            if (!validity(number, 12) || !validity(pin, 4)) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), number));
            } else {
                if (validCreditCards.containsKey(number) && validCreditCards.getString(number).equals(pin)) {
//                if (number.equals(numberOfCard) && pin.equals(pinCode)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), number));
                    break;
                }
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }

        }
    }

    private boolean validity(String number, int len) {
        if (number.length() != len)
            return false;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

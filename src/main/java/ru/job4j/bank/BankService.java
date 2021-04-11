package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {

    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List <Account> acc = users.get(user);
        if(user != null) {
            acc.add(account);
            users.putIfAbsent(user, acc);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)){
                user = us;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if(user != null) {
            for (Account usrAcc : users.get(user)) {
                if (usrAcc.getRequisite().equals(requisite)) {
                    account = usrAcc;
                }
            }
        }

        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if(src != null && src.getBalance() >= amount && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает логику простейших банковских опреций, таких как: добваление
 * пользователя в систему, добавление аккаунта,
 * поиск пользователя по паспорту, поиск аккаунта по паспорту и реквезитам, перевод средств.
 * @author ROMAN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа HashMap,
     * в которой в качестве ключа хранится структура
     * данных User(пользователь), которая в качестве полей
     * содержит паспорт и имя пользователя. В качестве значения хранит
     * лист аккаунтов(list<Account>).
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход объект типа User, который является
     * ключем, и если такой пользователь не найден, добавляет его в HashMap.
     * @param user пользователь , если такого еще нет, то он добавляется в HashMap.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод, который принимает на вход паспортные данные и аккаунт,
     * ищет по паспорту пользователя и добавляет к нему новый аккаунт, если такого еще нет.
     * @param passport паспортые данные, по которым ищем пользователя
     * @param account аккаунт, который добавится, если такого еще нет в системе.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAcc = users.get(user);
            if (!userAcc.contains(account)) {
                userAcc.add(account);
            }
        }
    }

    /**
     * Метод, принимает на вход паспортные данные, и ищет по ним пользователя в системе.
     * @param passport искомые паспортные данные
     * @return возвращает пользователя, по паспортным данным
     * , если такого не найдено возвращает null.
     */
    public Optional<User> findByPassport(String passport) {
       return users.keySet()
               .stream().filter(s -> s.getPassport().equals(passport))
               .findFirst();
        }

    /**
     * Метод, принимающий на вход паспортные данные пользователя и реквизиты аккаунта.
     * Осуществляет поиск аккаунта пользователя по паспортным данным и реквизитам.
     * @param passport искомые поспортные данные, если
     *                 пользователь не найден - метод возвращает null
     * @param requisite искомые реквизиты.
     * @return возвращет аккаунт, если такой есть, иначе возвращает null/
     */
    public Account findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

        /**
         * Метод, осуществляющие перевод денег одного аккаунта на другой.
         * Принимает на вход паспортные данные и реквизиты
         * аккаунтна пользователя у которого спишутся средства
         * и паспортные данные и реквизиты аккаунтна пользователя
         * к которому стредства переведуться, а так же
         * саму сумму.
         * @param srcPassport паспортные данные пользователя
         *                    у которого спишутся средства
         * @param srcRequisite реквизиты аккаунта пользователя,
         *                    с которого спишутся средства
         * @param destPassport паспортные данные пользователя
         *                    к которому стредства переведуться
         * @param destRequisite реквизиты аккаунта пользователя
         *                      , к которому стредства переведуться
         * @param amount сумма перевода
         * @return возвращает boolean переменную об успешности операции
         */
        public boolean transferMoney(String srcPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
            boolean rsl = false;
            var src = findByRequisite(srcPassport, srcRequisite);
            var dest = findByRequisite(destPassport, destRequisite);
            if (src != null && src.getBalance() >= amount && dest != null) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                rsl = true;
            }
            return rsl;
        }
    }

package ru.job4j.ex;


public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String i : value) {
            if (i.equals(key)) {
                rsl = 1;
                break;
            }
            if (rsl == -1) {
                throw new ElementNotFoundException("Element not found");
            }
        }
        return rsl;
    }

        public static void main (String[]args) throws ElementNotFoundException {
            String[] el = {"a", "b", "c", "d"};
            String key = "a";
            try {
                int rsl = indexOf(el, key);
                System.out.println(rsl);
            } catch (ElementNotFoundException e){
                e.printStackTrace();
            }
        }
    }

package com.aktasci;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        OptionalExample opt = new OptionalExample();

        Integer value1 = null;
        Integer value2 = new Integer(5);


        //allows passed parameter to be null
        Optional<Integer> value1Opt = Optional.ofNullable(value1);

        //throws NPE if the passes parameter is null
        Optional<Integer> value2Opt = Optional.of(value2);

        System.out.println("value1Opt = " + value1Opt);
        System.out.println("value2Opt = " + value2Opt);

        System.out.println(opt.sum(value1Opt, value2Opt));

        String temp = null;
        System.out.println("temp is null");
        System.out.println("calling orElse");
        //getDefaultValue() is called
        System.out.println(Optional.ofNullable(temp).orElse(opt.getDefaultValue()));
        System.out.println("calling orElseGet");
        //getDefaultValue() is called
        System.out.println(Optional.ofNullable(temp).orElseGet(() -> opt.getDefaultValue()));

        temp = "Not Empty";
        System.out.println("temp is not null");
        System.out.println("calling orElse");
        //getDefaultValue() is called but not set to the value. So make an unnecessary call and create unnecessary
        // objects
        System.out.println(Optional.ofNullable(temp).orElse(opt.getDefaultValue()));
        System.out.println("calling orElseGet");
        //getDefaultValue() is not called
        System.out.println(Optional.ofNullable(temp).orElseGet(() -> opt.getDefaultValue()));

        System.out.println("result of division " + opt.divide(Optional.of(5), Optional.of(1)));
        System.out.println("result of division " + opt.divide(Optional.of(5), Optional.of(null)));
    }

    private Integer sum(Optional<Integer> value1Opt, Optional<Integer> value2Opt) {

        //checks the value is present(true) or not(false)
        System.out.println("value1Opt = [" + value1Opt.isPresent() + "], value2Opt = [" + value2Opt.isPresent() + "]");

        //if value1Opt is present returns its value, else returns default value passed
        Integer value1 = value1Opt.orElse(0);
        Integer value2 = value2Opt.get();

        return value1 + value2;
    }

    public String getDefaultValue() {
        System.out.println("Getting default value");
        return "Default Value";
    }

    private Integer divide(Optional<Integer> first, Optional<Integer> second) {
        return first.orElseThrow(IllegalArgumentException::new) / second.orElseThrow(IllegalArgumentException::new);
    }

}

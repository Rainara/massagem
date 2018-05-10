package com.twu.massagem.validation;

import com.twu.massagem.model.MassageDay;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MassageValidation {

    private List<LocalDate> dates;
    private int quantity;

    public MassageValidation(List<LocalDate> dates, int quantity) {
        this.dates = dates;
        this.quantity = quantity;
    }

    public boolean isEqualQuantityAndInformedDates() {

        if(!dates.isEmpty() && quantity==dates.size() && quantity>0) {
            if(countDuplicatedDates()==0)
                return true;
        }
        return false;
    }

    public int countDuplicatedDates(){

        List<LocalDate> distinctList = (List<LocalDate>)dates.stream().distinct().collect(Collectors.toList());
        int duplicatedItems = dates.size()-distinctList.size();

        return duplicatedItems;
    }

    public boolean isTheDateInAnAcceptableRange() {

        LocalDate today = LocalDate.now();

        for (LocalDate date : dates) {

            if (date.isBefore(today)) {
                return false;
            }
        }
        return true;
    }

    public boolean isTheInputGivenValidated(){

        if(isEqualQuantityAndInformedDates() && isTheDateInAnAcceptableRange()){
            return true;
        }
        return false;
    }


}

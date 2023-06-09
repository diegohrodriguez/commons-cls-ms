package com.cls.domain.ports.commons.utilities;


import com.cls.model.dto.addfee.ViewFee;
import com.cls.model.dto.commons.AdditionalOperation;
import com.cls.model.dto.commons.AdditionalStandard;
import com.cls.model.entity.addfee.ViewFeeEntity;
import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.entity.commons.AdditionalOperationEntity;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class FeeCalculator {

    public BigDecimal calculateFee(ViewFee feeBasic, Integer totalKms) {
        BigDecimal feePrice = new BigDecimal(0);
        if (totalKms != null && totalKms > 0) {
            feePrice = BigDecimal.valueOf(feeBasic.getFeePriceXKm()).multiply(BigDecimal.valueOf(totalKms));
        }
        feePrice=feePrice.add(BigDecimal.valueOf(feeBasic.getFeePrice()));
        System.out.println("feePrice: " + feePrice);
        return feePrice;
    }

    public BigDecimal calculateTotalAdditionalOperationsFee(List<AdditionalFee> operativeAdditionalsRequest, List<AdditionalOperation> operativeAdditionalsDataBase) {
        BigDecimal totalStandardFee = new BigDecimal(0);
        for (AdditionalOperation additionalOperation : operativeAdditionalsDataBase) {
            if (additionalOperation.getOperationId() == 1) {
                totalStandardFee=totalStandardFee.add(BigDecimal.valueOf(additionalOperation.getPrice()));
            } else {
                for (AdditionalFee additionalFee : operativeAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalOperation.getId())) {
                        totalStandardFee=totalStandardFee.add(BigDecimal.valueOf(additionalFee.getAmount()).multiply(BigDecimal.valueOf(additionalOperation.getPrice())));
                        operativeAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public BigDecimal calculateTotalAdditionalStandardsFee(List<AdditionalFee> standardAdditionalsRequest, List<AdditionalStandard> standardAdditionalsDataBase) {
        BigDecimal totalStandardFee = new BigDecimal(0);
        for (AdditionalStandard additionalStandard : standardAdditionalsDataBase) {
            if (additionalStandard.getOperationId() == 1) {
                totalStandardFee=totalStandardFee.add(BigDecimal.valueOf(additionalStandard.getPrice()));
            } else {
                for (AdditionalFee additionalFee : standardAdditionalsRequest) {
                    if (Objects.equals(additionalFee.getCode(), additionalStandard.getId())) {
                        totalStandardFee=totalStandardFee.add(BigDecimal.valueOf(additionalFee.getAmount()).multiply(BigDecimal.valueOf(additionalStandard.getPrice())));
                        standardAdditionalsRequest.remove(additionalFee);
                        break;
                    }
                }
            }
            System.out.println("totalStandardFee: " + totalStandardFee);
        }
        return totalStandardFee;
    }

    public BigDecimal calculateTotalFee(BigDecimal baseFee, BigDecimal standardFee, BigDecimal operativeFee) {
        return baseFee.add(standardFee.add(operativeFee));
    }

    public Date getDateISO8601(ZoneOffset zoneOffset, DateTimeFormatter dateTimeFormatter) {
        return new Date(ZonedDateTime.now(zoneOffset).format(dateTimeFormatter));
    }
}

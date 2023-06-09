package com.cls.domain.ports.updatefee.in;


import com.cls.model.request.updatefee.UpdateFeeRequest;
import com.cls.model.response.updatefee.UpdateFeeResponse;

/**
 * <h3>This interface is an abstraction of methods for store files in a folder</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
public interface UpdateFeeManagement {
    UpdateFeeResponse updateFee(UpdateFeeRequest updateFeeRequest);

}

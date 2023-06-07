package com.cls.domain.ports.getbasicfee.out;


import com.cls.model.dao.getbasicfee.BasicFeeDao;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ViewFeesManagementRepository {

    List<BasicFeeDao> findBasicFee(@Param("ramo_codigo_siab") String ramoCodigoSiab,
                                   @Param("producto_codigo_siab") String productoCodigoSiab,
                                   @Param("causa_codigo_siab") Integer causaCodigoSiab,
                                   @Param("origin_destination_id") Integer originDestinationId,
                                   @Param("codigo_siab_city") Integer codigoSiabCity);

}

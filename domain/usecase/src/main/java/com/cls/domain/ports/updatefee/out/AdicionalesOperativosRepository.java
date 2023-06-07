package com.cls.domain.ports.updatefee.out;


import com.cls.model.dao.updatefee.AdicionalOperativoDao;
import com.cls.model.dto.updatefee.TarifaAdicional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdicionalesOperativosRepository {
    List<AdicionalOperativoDao> getPrice(List<TarifaAdicional> tarifaAdicional);
}

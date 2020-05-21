package com.itmck.service.impl;

import com.itmck.service.RiskIcrQueryService;
import org.springframework.stereotype.Service;

/**
 * Create by it_mck 2019/10/15 19:26
 *
 * @Description:
 * @Version: 1.0
 */
@Service
public class RiskIcrQueryServiceImpl implements RiskIcrQueryService {

    @Override
    public String queryList() throws Exception {

        return "hello interface";
    }

    @Override
    public String respInformation() {

        try {
            int x = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ArithmeticException();
        }

        return "qwe";
    }
}

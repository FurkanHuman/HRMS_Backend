package io.kodlama.hrms.core.adapters.cocretes;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.core.adapters.abstracts.RealCheckService;
import io.kodlama.hrms.core.adapters.models.mernisPerson;

@Service
public class FakeMernisAdapter implements RealCheckService {

    @Override
    public boolean validate(mernisPerson mernisPerson) {
        if (mernisPerson.getIdentificationNumber().length() == 11)
            return true;
        return false;
    }

}

package io.kodlama.hrms.core.adapters.cocretes;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.core.adapters.abstracts.EmailSenderService;

@Service
public class FakeEmailAdapter implements EmailSenderService {

    @Override
    public void sendMail(String content) {
        System.out.println(content);
    }

}

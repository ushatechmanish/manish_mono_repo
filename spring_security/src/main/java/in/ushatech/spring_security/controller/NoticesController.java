package in.ushatech.spring_security.controller;


import in.ushatech.spring_security.entity.NoticeDetail;
import in.ushatech.spring_security.repository.NoticeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

// working
@RestController
public class NoticesController
{

    @Autowired
    private NoticeDetailRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeDetail>> getNotices()
    {
        List<NoticeDetail> notices = noticeRepository.findAllActiveNotices();
        if (notices != null)
        {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else
        {
            return null;
        }
    }

}

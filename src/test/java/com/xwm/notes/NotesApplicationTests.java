package com.xwm.notes;

import com.xwm.notes.domain.Note;
import com.xwm.notes.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesApplicationTests {
    @Autowired
    private NoteService noteService;

    @Test
    public void contextLoads() {




    }

}

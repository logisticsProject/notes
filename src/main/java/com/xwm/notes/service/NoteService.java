package com.xwm.notes.service;


import com.xwm.notes.domain.Note;
import com.xwm.notes.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    public List<Note> allNote(String title){
        return noteMapper.allNotes(title);
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int delNote(int id){
        return noteMapper.delNote(id);
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addNote(Note note){
        return  noteMapper.addNote(note);
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updNote(Note note){
        return noteMapper.updNote(note);
    }

    public Note findById(int id){
        return noteMapper.findById(id);
    }
}

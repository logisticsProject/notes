package com.xwm.notes.controller;

import com.xwm.notes.domain.ErrMsg;
import com.xwm.notes.domain.Note;
import com.xwm.notes.service.NoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value="allnotes",method = RequestMethod.GET)
    public ResponseEntity<?> allNote(@RequestParam("title") String title){
        List<Note> noteList=noteService.allNote(title);
        if (noteList.isEmpty()){
            return new ResponseEntity<>(new ErrMsg("找不到任何信息"),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(noteList,HttpStatus.OK);
        }
    }


    @RequestMapping(value = "delnote/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delNote(@PathVariable(value = "id") Integer id ){
           int fluRows=noteService.delNote(id);
        if (fluRows>0){

            return new ResponseEntity<>(fluRows,HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrMsg("删除信息失败！"),HttpStatus.OK);
    }

    @RequestMapping(value = "mngnote",method = RequestMethod.POST)
    public ResponseEntity<?> addNote(/*@RequestBody Note note*/@Param(value = "id") Integer id,
                                                               @Param(value = "title") String title,
                                                               @Param(value = "time")@DateTimeFormat(pattern = "yyyy-MM-dd") Date time,
                                                               @Param(value = "content") String content){

        System.out.println(id+"    "+title+"   "+time+"  "+content);

        Note note=new Note(id,title,content,time);
        if(note.getId()==0){
            int fluRows=noteService.addNote(note);
            if (fluRows>0){

                return new ResponseEntity<>(fluRows,HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrMsg("增加信息失败！"),HttpStatus.OK);
        }
        else {
            int fluRows=noteService.updNote(note);
            if (fluRows>0){

                return new ResponseEntity<>(fluRows,HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrMsg("修改信息失败！"),HttpStatus.OK);
        }
        }





    @RequestMapping(value = "findnote",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@Param("id") Integer id){
        Note note=noteService.findById(id);
       return new ResponseEntity<>(note,HttpStatus.OK);
    }
}

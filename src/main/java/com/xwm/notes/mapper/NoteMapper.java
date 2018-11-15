package com.xwm.notes.mapper;

import com.xwm.notes.domain.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteMapper {
  /*  @Results({
            @Result(property = "time",column = "date")
    })
    @Select("select * from notes")*/
    List<Note> allNotes(@Param("title") String title);


    @Delete("delete from notes where id=#{id}")
    int delNote(@Param("id") int id);
    @Update("update notes set title=#{title},content=#{content},date=#{time} where id=#{id}")
    int updNote(Note note);
    @Insert("insert into notes values(null,#{title},now(),#{content})")
    int addNote(Note note);
    @Results({
            @Result(property = "time",column = "date")
    })
    @Select("select * from notes where id=#{id}")
    Note findById(int id);

}

package com.mistershorr.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonScale;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHighA;
    private Button buttonHighBb;
    private Button buttonHighB;
    private Button buttonHighC;
    private Button buttonHighCs;
    private Button buttonHighD;
    private Button buttonHighDs;
    private Button buttonHighE;
    private Button buttonHighF;
    private Button buttonHighFs;
    private Button buttonHighG;
    private Button buttonHighGs;
    private Button buttonSong1;
    private Button buttonSong2;
    private Button buttonSong3;
    private EditText numTimes;
    private SoundPool soundPool;

    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHighA;
    private int noteHighBb;
    private int noteHighB;
    private int noteHighC;
    private int noteHighCs;
    private int noteHighD;
    private int noteHighDs;
    private int noteHighE;
    private int noteHighF;
    private int noteHighFs;
    private int noteHighG;
    private int noteHighGs;

    private Map<Integer, Integer> noteMap;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int WHOLE_NOTE =1000; //in ms
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map you store a key:value pair
        //the key is the button ID, the value is the NoteID
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_ha, noteHighA);
        noteMap.put(R.id.button_synth_hbb, noteHighBb);
        noteMap.put(R.id.button_synth_hb, noteHighB);
        noteMap.put(R.id.button_synth_hc, noteHighC);
        noteMap.put(R.id.button_synth_hcs, noteHighCs);
        noteMap.put(R.id.button_synth_hd, noteHighD);
        noteMap.put(R.id.button_synth_hds, noteHighDs);
        noteMap.put(R.id.button_synth_he, noteHighE);
        noteMap.put(R.id.button_synth_hf, noteHighF);
        noteMap.put(R.id.button_synth_hfs, noteHighFs);
        noteMap.put(R.id.button_synth_hg, noteHighG);
        noteMap.put(R.id.button_synth_hgs, noteHighGs);


    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10,
                AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea,1);
        noteBb = soundPool.load(this, R.raw.scalebb,1);
        noteB = soundPool.load(this, R.raw.scaleb,1);
        noteC = soundPool.load(this, R.raw.scalec,1);
        noteC = soundPool.load(this, R.raw.scalec,1);
        noteCs = soundPool.load(this, R.raw.scalecs,1);
        noteD = soundPool.load(this, R.raw.scaled,1);
        noteDs = soundPool.load(this, R.raw.scaleds,1);
        noteE = soundPool.load(this, R.raw.scalee,1);
        noteF = soundPool.load(this, R.raw.scalef,1);
        noteFs = soundPool.load(this, R.raw.scalefs,1);
        noteG = soundPool.load(this, R.raw.scaleg,1);
        noteGs = soundPool.load(this, R.raw.scalegs,1);
        noteHighA = soundPool.load(this, R.raw.scalehigha,1);
        noteHighBb = soundPool.load(this, R.raw.scalehighbb,1);
        noteHighB = soundPool.load(this, R.raw.scalehighb,1);
        noteHighC = soundPool.load(this, R.raw.scalehighc,1);
        noteHighCs = soundPool.load(this, R.raw.scalehighcs,1);
        noteHighD = soundPool.load(this, R.raw.scalehighd,1);
        noteHighDs = soundPool.load(this, R.raw.scalehighds,1);
        noteHighE = soundPool.load(this, R.raw.scalehighe,1);
        noteHighF = soundPool.load(this, R.raw.scalehighf,1);
        noteHighFs = soundPool.load(this, R.raw.scalehighfs,1);
        noteHighG = soundPool.load(this, R.raw.scalehighg,1);
        noteHighGs = soundPool.load(this, R.raw.scalehighgs,1);



    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonHighA.setOnClickListener(noteListener);
        buttonHighBb.setOnClickListener(noteListener);
        buttonHighB.setOnClickListener(noteListener);
        buttonHighC.setOnClickListener(noteListener);
        buttonHighCs.setOnClickListener(noteListener);
        buttonHighD.setOnClickListener(noteListener);
        buttonHighDs.setOnClickListener(noteListener);
        buttonHighE.setOnClickListener(noteListener);
        buttonHighF.setOnClickListener(noteListener);
        buttonHighFs.setOnClickListener(noteListener);
        buttonHighG.setOnClickListener(noteListener);
        buttonHighGs.setOnClickListener(noteListener);
        buttonScale.setOnClickListener(this);
        buttonSong1.setOnClickListener(this);
        buttonSong2.setOnClickListener(this);
        buttonSong3.setOnClickListener(this);
        numTimes.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonHighA = findViewById(R.id.button_synth_ha);
        buttonHighBb = findViewById(R.id.button_synth_hbb);
        buttonHighB = findViewById(R.id.button_synth_hb);
        buttonHighC = findViewById(R.id.button_synth_hc);
        buttonHighCs = findViewById(R.id.button_synth_hcs);
        buttonHighD = findViewById(R.id.button_synth_hd);
        buttonHighDs = findViewById(R.id.button_synth_hds);
        buttonHighE = findViewById(R.id.button_synth_he);
        buttonHighF = findViewById(R.id.button_synth_hf);
        buttonHighFs = findViewById(R.id.button_synth_hfs);
        buttonHighG = findViewById(R.id.button_synth_hg);
        buttonHighGs = findViewById(R.id.button_synth_hgs);
        buttonScale = findViewById(R.id.button_synth_scale);
        buttonSong1 = findViewById(R.id.button_synth_song1);
        buttonSong2= findViewById(R.id.button_synth_song2);
        buttonSong3 = findViewById(R.id.button_synth_song3);
        numTimes = findViewById(R.id.edittext_synth_numtimes);

    }

    @Override

    public void onClick(View view) {
        // one method to handle the clicks of all the buttons
        // but don't forget to tell the buttons who is doing
        // the listening.

        switch(view.getId()) {
            /*
            case R.id.button_synth_a:
                playNote(noteA);
                break;
            case R.id.button_synth_bb:
                playNote(noteBb);
                break;
            case R.id.button_synth_b:
                playNote(noteB);
                break;
            case R.id.button_synth_c:
                playNote(noteC);
                break;
            case R.id.button_synth_cs:
                playNote(noteCs);
                break;
            case R.id.button_synth_d:
                playNote(noteD);
                break;
            case R.id.button_synth_ds:
                playNote(noteDs);
                break;
            case R.id.button_synth_e:
                playNote(noteE);
                break;
            case R.id.button_synth_f:
                playNote(noteF);
                break;
            case R.id.button_synth_fs:
                playNote(noteFs);
                break;
            case R.id.button_synth_g:
                playNote(noteG);
                break;
            case R.id.button_synth_gs:
                playNote(noteGs);
                break;
               */
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synth_song1:
                playTwinkleStar();
                break;
            case R.id.button_synth_song2:
                playRunaway();
                break;
            case R.id.button_synth_song3:
                playLeanOnMe();
                break;
        }

    }

    private void playLeanOnMe() {
        int delayMs = Note.WHOLE_NOTE/20*25;
        ArrayList<Integer> leanOnMe =new ArrayList<Integer>(Arrays.asList(
                noteC, noteC, noteD, noteE, noteF, noteF, noteE, noteD, noteC,
                noteC, noteD, noteE, noteE, noteD, noteD, noteC, noteC, noteD, noteE, noteF,
                noteF, noteE, noteD, noteC, noteC, noteD, noteE, noteB, noteC, noteC, noteHighE,
                noteHighD,
                noteHighC, noteHighE, noteHighD, noteHighD,noteHighD, noteHighC, noteHighD,
                noteHighA, noteG, noteHighC, noteHighB, noteHighA,noteG,
                noteHighC, noteHighD, noteHighE, noteHighE, noteHighD, noteHighC, noteHighD,
                noteHighE, noteHighD,
                noteHighC, noteHighE,noteHighD,noteHighC, noteHighC,noteHighE, noteHighD,noteHighD,
                noteHighD,noteHighC, noteHighD, noteHighA, noteG,
                noteHighC, noteHighB, noteHighA, noteG, noteHighE, noteHighD, noteHighC,
                noteHighC));
        //noteHighD, noteHighD, noteHighE, noteHighD, noteHighC
        Song song3 = new Song();
        for(int i = 0; i<leanOnMe.size(); i++){
            if(i==0||i==15||i==32||i==55){
                song3.add(new Note(leanOnMe.get(i),delayMs));
            }
            else if(i==4||i==8||i==14||i==19||i==23||i==29||i==44||i==67||i==74||i==87) {
                if(i!=14||i!=29||i!=67){
                    song3.add(new Note(leanOnMe.get(i),delayMs*8/10));
                }
                else{
                    song3.add(new Note(leanOnMe.get(i),delayMs*5/4));
                }
            }
            else{
                song3.add(new Note(leanOnMe.get(i), delayMs/4));
            }
        }
        playSong(song3);
    }

    private void playRunaway() {
        ArrayList<Integer> runaway = new ArrayList<Integer>(Arrays.asList(noteHighC,noteHighC,
                noteHighC,noteHighC,noteHighC,noteHighC,noteHighC,noteC, noteHighB, noteHighB, noteHighB,
                noteB, noteHighA, noteHighA, noteHighA, noteA, noteF, noteF, noteE, noteHighC,
                noteHighC, noteHighC, noteHighC, noteC, noteHighB, noteHighB,noteHighB,noteB,
                noteHighA, noteHighA,noteHighA,noteA, noteF,noteF, noteF, noteE, noteHighC));
        Song song2 = new Song();
        for(int i = 0; i< runaway.size();i++){
            song2.add(new Note(runaway.get(i),(WHOLE_NOTE/25*40)));
        }
        playSong(song2);
    }

    private void playTwinkleStar() {
        ArrayList<Integer> twinkleStar = new ArrayList<Integer>(Arrays.asList(noteG, noteG,
                noteHighD, noteHighD,noteHighE, noteHighE, noteHighD, noteHighC, noteHighC,
                noteHighB,noteHighB, noteHighA, noteHighA, noteG, noteHighD, noteHighD,
                noteHighC, noteHighC, noteHighB, noteHighB, noteHighA,noteHighD, noteHighD,
                noteHighC,noteHighC, noteHighB, noteHighB, noteHighA,noteG,noteG,noteHighD,
                noteHighD,noteHighE,noteHighE,noteHighD, noteHighC,noteHighC,noteHighB,
                noteHighB,noteHighA,noteHighA,noteG));
        Song song1 = new Song();
        for(int i = 1; i<=twinkleStar.size();i++) {
            if(i%7==0){
                song1.add(new Note(twinkleStar.get(i-1), (WHOLE_NOTE)));
            }
            else {
                song1.add(new Note(twinkleStar.get(i-1), (WHOLE_NOTE / 2)));
            }

        }
        playSong(song1);
    }


    private void playScale() {
        //play all the notes one at a time with a delay in between
        Song scale = new Song();

        scale.add(new Note(noteA,WHOLE_NOTE));
        scale.add(new Note(noteB,WHOLE_NOTE));
        scale.add(new Note(noteC,WHOLE_NOTE));
        scale.add(new Note(noteCs,WHOLE_NOTE));
        scale.add(new Note(noteD,WHOLE_NOTE));
        scale.add(new Note(noteDs,WHOLE_NOTE));
        scale.add(new Note(noteE,WHOLE_NOTE));
        scale.add(new Note(noteF,WHOLE_NOTE));
        scale.add(new Note(noteFs,WHOLE_NOTE));
        scale.add(new Note(noteG,WHOLE_NOTE));
        scale.add(new Note(noteGs,WHOLE_NOTE));
        scale.add(new Note(noteHighA,WHOLE_NOTE));
        scale.add(new Note(noteHighB,WHOLE_NOTE));
        scale.add(new Note(noteHighC,WHOLE_NOTE));
        scale.add(new Note(noteHighCs,WHOLE_NOTE));
        scale.add(new Note(noteHighD,WHOLE_NOTE));
        scale.add(new Note(noteHighDs,WHOLE_NOTE));
        scale.add(new Note(noteHighE,WHOLE_NOTE));
        scale.add(new Note(noteHighF,WHOLE_NOTE));
        scale.add(new Note(noteHighFs,WHOLE_NOTE));
        scale.add(new Note(noteHighG,WHOLE_NOTE));
        scale.add(new Note(noteHighGs,WHOLE_NOTE));
        playSong(scale);

    }

    private void playSong(Song scale) {
        int numPlayed = 0;
        try{
             numPlayed = Integer.parseInt(numTimes.getText().toString());
        }
        catch(NumberFormatException e){
             //make a toast
            Toast.makeText(
                    getBaseContext(), "No Number Has Been Inputed",
                    Toast.LENGTH_LONG).show();
        }

        for(int i =0; i<numPlayed; i++) {
            for (Note note : scale.getNotes()) {
                playNote(note);
                delay(note.getDelay());
            }
        }

    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME,
                DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }
    private void playNote(Note note){
        playNote(note.getNoteId());
    }
    private void playNote(int note) {
        playNote(note, 0);
    }
    private class KeyboardNoteListener implements View.OnClickListener
    {
        //get the id of the button that was clicked

        @Override
        public void onClick(View v) {
            int id = v.getId();
            //use the map to figure out what note to play
            int note = noteMap.get(id);
            //play the note
            playNote(note);
        }
    }
}









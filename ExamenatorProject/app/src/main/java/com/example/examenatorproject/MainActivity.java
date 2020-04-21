package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.ContentValues;
import android.content.Intent;
<<<<<<< HEAD
import android.content.pm.ActivityInfo;
=======
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
>>>>>>> aef97ba6fbf1a409fee8bd19654e4441ed953932
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenatorproject.Data.QuestionAppDatabase;
import com.example.examenatorproject.Data.TicketAppDatabase;
import com.example.examenatorproject.Model.Question;
import com.example.examenatorproject.Model.Ticket;

import java.util.ArrayList;

import static android.content.pm.ActivityInfo.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private TicketAppDatabase ticketAppDatabase;
    private ArrayList<Ticket> ticketsArrayList = new ArrayList<>();

   // private QuestionAppDatabase questionAppDatabase;
    private ArrayList<Question> questionsArrayList = new ArrayList<>();

    private TextView progressQuestion;
    private ProgressBar progressBarDoneAnswer;

    private TextView progressTicket;
    private ProgressBar progressBarDoneTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //set progresses bar values
        int rightQuestion = getRightElements(db, DbHelper.TABLE_QUESTION);
        int rightTicket = getRightElements(db, DbHelper.TABLE_TICKET);

        setProgressValues(rightTicket, rightQuestion);

/*        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        //ТАБЛИЦА БИЛЕТОВ
        for(int i = 1; i < 16; i++)
        {
            ContentValues cv = new ContentValues();
            cv.put(DbHelper._ID, i);
            cv.put(DbHelper.STATUS, 0);
            database.insert(DbHelper.TABLE_TICKET, null, cv);
        }

        //ТАБЛИЦА ВОПРОСОВ И АССОЦИАЦИЙ
        int index = 0;
        int tickID = 1;
        for (String[] s:getQuestions())
        {
            //вопрос
            index++;
            ContentValues cv = new ContentValues();
            cv.put(DbHelper._ID, index);
            cv.put(DbHelper.STATUS, 0);
            cv.put(DbHelper.TEXT, s[0]);
            cv.put(DbHelper.IMAGE, s[1]);
            database.insert(DbHelper.TABLE_QUESTION, null, cv);
            //ассоциативная таблица
            ContentValues cvUNION = new ContentValues();
            cvUNION.put(DbHelper.TICKET_ID, tickID);
            cvUNION.put(DbHelper.QUESTION_ID, index);
            database.insert(DbHelper.TABLE_UNION, null, cvUNION);

            if (index % 5 == 0)
                tickID ++;
        }

        //ПРОСМОТРТ ПРАВИЛЬНОСТИ ЗАПОЛНЕНИЯ БД
        Cursor cursor = database.query(DbHelper.TABLE_UNION, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int tickIndex = cursor.getColumnIndex(DbHelper.TICKET_ID);
            int queIndex = cursor.getColumnIndex(DbHelper.QUESTION_ID);
            do {
                Log.d("mLog", "tickIndex = " + cursor.getInt(tickIndex) +
                        ", queIndex = " + cursor.getInt(queIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        cursor.close();

        cursor = database.query(DbHelper.TABLE_QUESTION, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DbHelper._ID);
            int statusIndex = cursor.getColumnIndex(DbHelper.STATUS);
            int textIndex = cursor.getColumnIndex(DbHelper.TEXT);
            int imageIndex = cursor.getColumnIndex(DbHelper.IMAGE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", status = " + cursor.getInt(statusIndex) +
                        ", text = " + cursor.getString(textIndex) +
                        ", image = " + cursor.getString(imageIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

<<<<<<< HEAD
        progressQuestion = findViewById(R.id.progressQuestion);
        progressBarDoneAnswer = findViewById(R.id.progressBarDoneAnswer);

        progressTicket = findViewById(R.id.progressTicket);
        progressBarDoneTicket = findViewById(R.id.progressBarDoneTicket);

        /*Room.databaseBuilder(getApplicationContext(), TicketAppDatabase.class, "QuestionDBNew")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();*/

        Utils.ticketAppDatabase = Room.databaseBuilder(getApplicationContext(),
                TicketAppDatabase.class, "TicketDBNew").allowMainThreadQueries().build();
        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());

        Utils.questionAppDatabase = Room.databaseBuilder(getApplicationContext(),
                QuestionAppDatabase.class, "QuestionDBNew").allowMainThreadQueries().build();


        questionsArrayList.addAll(Utils.questionAppDatabase.getQuestionDAO().getAllQuestions());

        if (Utils.numberQuestion.size() == 0)
            setQuestionValueToList();

        if (Utils.numberTicket.size() == 0)
            setTicketValueToList();

        //Utils.ticketAppDatabase.getTicketDAO().clearTable();
       // Utils.questionAppDatabase.getQuestionDAO().clearTable();
        //questionAppDatabase.getQuestionDAO().clearTable();
        //temp();
        //temp2();
       //Toast.makeText(this, "Tickets: " + ticketsArrayList.size(), Toast.LENGTH_SHORT).show();
       //Toast.makeText(this, "Questions: " + questionsArrayList.size(), Toast.LENGTH_SHORT).show();
       //Toast.makeText(this,  questionsArrayList.get(5).getNumber_ticke() + " - " + questionsArrayList.get(5).getQuestion(), Toast.LENGTH_LONG).show();

        progressTicket.setText(Utils.ticketPassed + "/" + ticketsArrayList.size());
        progressQuestion.setText(Utils.questionPassed + "/" + questionsArrayList.size());

        progressBarDoneAnswer.setProgress(Utils.questionPassed);
        progressBarDoneTicket.setProgress(Utils.ticketPassed);
=======
        cursor.close();

        dbHelper.close();*/
>>>>>>> aef97ba6fbf1a409fee8bd19654e4441ed953932
    }

    public List<String[]> getQuestions()
    {
        List<String[]> list = new ArrayList<String[]>();

        //Билет 1
        //1
        list.add(new String[]{"Дать определение «Техническое обслуживание». (ПТБ гл.1 п.43)", ""});
        //2
        list.add(new String[]{"Что не допускается делать в аккумуляторном помещении? (ПТЭ гл.16 п.365)", ""});
        //3
        list.add(new String[]{"Кто назначается производителем работ, за что отвечает производитель работ? (ПTБ гл.3 п.38)", ""});
        //4
        list.add(new String[]{"Что применяется для временного ограждения токоведущих частей, оставшихся под напряжением, какие плакаты безопасности вывешиваются на временных ограждениях? (ПTБ гл.15 п.168)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при поражении электрическим током", ""});


        //Билет 2
        //1
        list.add(new String[]{"Дать определение «охранная зона кабельных линий электропередачи и кабельных линий связи». (ПТБ гл.1 п.26)", ""});
        //2
        list.add(new String[]{"Как присоединяются части электроустановок к сети заземления? Как выполняются присоединения заземляющих проводников к заземлителю и к заземляющим конструкциям? (ПТЭ гл.13 п. 308,310)", ""});
        //3
        list.add(new String[]{"Кто назначается допускающим, за что отвечает допускающий? (ПTБ гл.3 п. 37)", ""});
        //4
        list.add(new String[]{"Установка заземлений в распределительных устройствах напряжением до 1000В. (ПТБ гл.15 п.152,155)", ""});
        //5
        list.add(new String[]{"Первая помощь пострадавшему при термических ожогах", ""});


        //Билет 3
        //1
        list.add(new String[]{"Дать определение «электротехнический персонал» и «электротехнологический персонал». (ПTБ гл.1 п.58,59)", ""});
        //2
        list.add(new String[]{"Какие знаки и надписи наносятся на электродвигатели и пускорегулирующие устройства? (ПТЭ гл.11п. 252,253)", ""});
        //3
        list.add(new String[]{"Правила временного ухода и возврата на рабочее место членов бригады. (ПТБ гл.10 п.111)", ""});
        //4
        list.add(new String[]{"Меры безопасности при выполнение работ на электродвигатели или приводимом им в движение механизме. (ПТБ гл.16 п.199)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при ранениях", ""});


        //Билет 4
        //1
        list.add(new String[]{"Дать определение «Наряд допуск». (ПTБ гл.1 п.39)", ""});
        //2
        list.add(new String[]{"Порядок включение электрооборудования, отключенного по заявке технологического персонала. (ПТЭ гл.3 п.44)", ""});
        //3
        list.add(new String[]{"За что отвечает наблюдающий? (ПTБ гл.3 п.39)", ""});
        //4
        list.add(new String[]{"Меры безопасности при выполнение работ под напряжением в электроустановках до 1000 В (ПTБ гл. 16 п. 180)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при кровотечениях", ""});


        //Билет 5
        //1
        list.add(new String[]{"Дать определение «Персонал оперативно-ремонтный». (ПTБ гл.1 п.14)", ""});
        //2
        list.add(new String[]{"На что обращается особое внимание при осмотре РУ? (ПТЭ гл.8 п.190)", ""});
        //3
        list.add(new String[]{"Порядок оформления перерывов в работе в течение рабочего дня. (ПTБ гл.12 п.119)", ""});
        //4
        list.add(new String[]{"В каких случаях допускается временное снятие заземлений. (ПТБ гл.15 п.153)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при переломах, вывихах, ушибах и растяжения связок", ""});


        //Билет 6
        //1
        list.add(new String[]{"Дать определение «Персонал оперативный». (ПTБ гл.1 п.15)", ""});
        //2
        list.add(new String[]{"В каких случаях электродвигатели должны быть немедленно отключены от сети? (ПТЭ гл.11 п.268)", ""});
        //3
        list.add(new String[]{"Порядок включения электроустановок оперативным персоналом после полного окончания работ. (ПТБ гл.14 п.127)", ""});
        //4
        list.add(new String[]{"Чем и как проверяется отсутствие напряжения в электроустановках до 1000 В с заземленной нейтралью? (ПTБ гл.15 п.139, 144)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при попадании инородных тел", ""});


        //Билет 7
        //1
        list.add(new String[]{"Дать определение «Действующая электроустановка». (ПTБ гл.1 п.32)", ""});
        //2
        list.add(new String[]{"Дать определение «текущий ремонт». (ПТЭ гл.1 п.2.1)", ""});
        //3
        list.add(new String[]{"Кто является ответственными за безопасное проведение работ? (ПTБ гл.3 п.31)", ""});
        //4
        list.add(new String[]{"Перечислить места вывешивания запрещающих плакатов. (ПTБ гл.15 п.137)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при обморожениях", ""});


        //Билет 8
        //1
        list.add(new String[]{"Дать определение «Электроустановка». (ПТБ гл.1 п.51)", ""});
        //2
        list.add(new String[]{"Допустимое напряжение на шинах распределительных устройств при работе электродвигателей. (ПТЭ гл.11 п.261)", ""});
        //3
        list.add(new String[]{"За что отвечает член бригады? (ПTБ гл.3 п.40)", ""});
        //4
        list.add(new String[]{"Где и для чего в электроустановках должны быть вывешены знаки (плакаты)? (ПTБ гл.15 п.167)", ""});
        //5
        list.add(new String[]{"Первая доврачебная медицинская помощь при химических ожогах", ""});


        //Билет 9
        //1
        list.add(new String[]{"Дать определение «Распоряжение». (ПTБ гл.1 п.40)", ""});
        //2
        list.add(new String[]{"Порядок при переключениях в электроустановках. (ПТЭ гл.3 п.46)", ""});
        //3
        list.add(new String[]{"Какие работы относятся к выполняемым в порядке текущей эксплуатации? (ПTБ гл.6 п.90)", ""});
        //4
        list.add(new String[]{"Порядок установки и снятия переносных заземлений. (ПTБ гл.15 п.146, 147)", ""});
        //5
        list.add(new String[]{"Первая доврачебная медицинская помощь при тепловом и солнечном ударе", ""});


        //Билет 10
        //1
        list.add(new String[]{"Дать определение «Работы, выполняемые в порядке текущей эксплуатации». (ПTБ гл.1 п.2)", ""});
        //2
        list.add(new String[]{"Что входит в объем ежесменного технического обслуживания? (ПТЭ гл.5 п.80)", ""});
        //3
        list.add(new String[]{"Где и какие работы допускается выполнять единолично производителю работ с группой IV? (ПTБ гл.5 п.73)", ""});
        //4
        list.add(new String[]{"Меры безопасности при выполнение работ под напряжением в электроустановках до 1000 В (ПTБ гл. 16 п. 180)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при отравлениях", ""});


        //Билет 11
        //1
        list.add(new String[]{"Дать определение «Подготовка рабочего места». (ПTБ гл.1 п.20)", ""});
        //2
        list.add(new String[]{"Минимальные расстояния до КЛ при проведение работ землеройными (ударными, вибропогружными) механизмами. (ПТЭ гл.10 п.245)", ""});
        //3
        list.add(new String[]{"Как передается и где регистрируется разрешение на подготовку рабочего места? (ПTБ гл.8 п.93,94)", ""});
        //4
        list.add(new String[]{"Что должно быть отключено при подготовке рабочего места? (ПTБ гл.15 п.131,135)", ""});
        //5
        list.add(new String[]{"Первая медицинская помощь при отравлении нефтяными газами", ""});


        //Билет 12
        //1
        list.add(new String[]{"Дать определение «Персонал ремонтный». (ПTБ гл.1 п.19)", ""});
        //2
        list.add(new String[]{"В чем заключается оперативное обслуживание электроустановок? (ПТЭ гл.3 п.28)", ""});
        //3
        list.add(new String[]{"Когда и кто проводит целевой инструктаж при работах по наряду? (ПTБ гл.9 п.102)", ""});
        //4
        list.add(new String[]{"Перечислить технические мероприятия, обеспечивающие безопасность работ со снятием напряжения. (ПTБ гл.15 п.130)", ""});
        //5
        list.add(new String[]{"Действия очевидца или пострадавшего согласно утвержденной схеме", ""});


        //Билет 13
        //1
        list.add(new String[]{"Дать определение «Заземление», «Защитное заземление». (ПTБ гл.1 п.16, 33)", ""});
        //2
        list.add(new String[]{"Что наносится на щиты и сборки сети освещения на лицевой и внутренней стороне? (ПТЭ гл.18 п.398, 399)", ""});
        //3
        list.add(new String[]{"Правила учета, хранения и выдачи ключей от электроустановок. (ПTБ гл.2 п.27)", ""});
        //4
        list.add(new String[]{"Где допускается устанавливать заземления при работе на эл. двигателях? (ПTБ гл.16 п.200)", ""});
        //5
        list.add(new String[]{"Что такое шаговое напряжение? Действия человека оказавшегося в зоне действия шагового напряжения?", ""});



        //Билет 14
        //1
        list.add(new String[]{"Дать определение «Комплектное распределительное устройство». (ПTБ гл.1 п.17)", ""});
        //2
        list.add(new String[]{"Кто допускается к работе с использованием переносных и передвижных электроприемников. Кто назначается для проведения периодических проверок переносных электроприемников и вспомогательного оборудования к ним. Его обязанности? (ПТЭ гл.22 п.512,516,517)", ""});
        //3
        list.add(new String[]{"Кто может выполнять единоличный осмотр электроустановок? (ПTБ гл.2 п.19, 20)", ""});
        //4
        list.add(new String[]{"Заполнение наряда-допуска для работы в электроустановках. (ПTБ прил. 3)", ""});
        //5
        list.add(new String[]{"В каких случаях проводят внеплановый инструктаж?", ""});



        //Билет 15
        //1
        list.add(new String[]{"Дать определение «Категория работ». (ПTБ гл.1 п.21)", ""});
        //2
        list.add(new String[]{"Какое должно применяться напряжение в особо опасных и помещениях с повышенной опасностью для питания переносных (ручных) светильников, ламп, вилки приборов и трансформаторов? (ПТЭ гл.18 п.402)", ""});
        //3
        list.add(new String[]{"Организация техники безопасности при эксплуатации электроустановок потребителей. (ПTБ гл.3 п.30)", ""});
        //4
        list.add(new String[]{"Меры безопасности при измерении мегомметром в процессе эксплуатации? (ПTБ гл.30 п.493,494,495)", ""});
        //5
        list.add(new String[]{"Дать определение что такое Основные и дополнительные средства защиты", ""});


        return list;
    }

    public int getRightElements(SQLiteDatabase database, String table)
    {
        int result = 0;

        Cursor cur = database.query(table, new String[] {DbHelper.STATUS}, null, null, null, null, null);
        if (cur.moveToFirst()) {
            do {
                System.out.println("**********************************************************");
                if(cur.getInt(cur.getColumnIndex(DbHelper.STATUS)) == 1)
                    result++;
            } while (cur.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cur.close();

        return result;
    }
    public void setProgressValues(int tick, int que)
    {
        ProgressBar barQue = (ProgressBar) findViewById(R.id.progressBarDoneQuestion);
        ProgressBar barTick = (ProgressBar) findViewById(R.id.progressBarDoneTicket);
        barQue.setProgress(que);
        barTick.setProgress(tick);

        TextView textQue = (TextView) findViewById(R.id.textQuestionProgress);
        TextView textTick = (TextView) findViewById(R.id.textTicketProgress);
        textQue.setText(String.valueOf(que) + "/75");
        textTick.setText(String.valueOf(tick) + "/15");
    }


    public void clickProgress(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }

    public void showTickets(View view) {
        Intent intent = new Intent(this, TicketListActivity.class);
        startActivity(intent);
    }

    public void clickQuestion(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void clickExam(View view) {
        Intent intent = new Intent(this, TicketActivity.class);
        startActivity(intent);
    }

    public void setQuestionValueToList() {
        for (int i = 0; i < 75; i++) {
            if (questionsArrayList.get(i).getStatus().equals("0")){
                Utils.numberQuestion.add(String.valueOf(i + 1));
                Utils.questionDuplicate.add(String.valueOf(i + 1));
            }else{
                Utils.statusQuestion[i] = true;
                Utils.questionPassed += 1;
            }
            Utils.countQuestion = Utils.numberQuestion.size();
        }
    }

    public void setTicketValueToList() {
        for (int i = 0; i < 15; i++){
            if (ticketsArrayList.get(i).getStatus().equals("0")){
                Utils.numberTicket.add(String.valueOf(i+1));
                Utils.ticketDuplicate.add(String.valueOf(i+1));
            }else{
                Utils.statusTicket[i] = true;
                Utils.ticketPassed += 1;
            }
        }
        Utils.countTicket = Utils.numberTicket.size();
    }

    private void createTicket(String status, int n){
        long id = Utils.ticketAppDatabase.getTicketDAO().addTicket(new Ticket(0, status, n));

        Ticket ticket = Utils.ticketAppDatabase.getTicketDAO().getTicket(id);

        if (ticket != null)
            ticketsArrayList.add(0, ticket);
    }

    private void updateTicket(String status, int position){
        Ticket ticket = ticketsArrayList.get(position);

        ticket.setStatus(status);

        Utils.ticketAppDatabase.getTicketDAO().updateTicket(ticket);
        ticketsArrayList.set(position, ticket);
    }



    private void deleteTicket(Ticket ticket, int position){
        ticketsArrayList.remove(position);
        Utils.ticketAppDatabase.getTicketDAO().deleteTicket(ticket);
    }

    private void temp(){
        for (int i = 1; i <= 15; i++) {
            createTicket("0", i);
        }
    }

    private void createQuestion(String numberTicket, String questionText, String questionStatus, String questionAnswer){
        long id = Utils.questionAppDatabase.getQuestionDAO().addQuestion(new Question(0, numberTicket,
                questionText, questionStatus, questionAnswer));

        Question question = Utils.questionAppDatabase.getQuestionDAO().getQuestion(id);

        if (question != null)
            questionsArrayList.add(0, question);
    }

    private void updateQuestion(String numberTicket, String questionText, String questionStatus, String questionAnswer, int position){
        Question question = questionsArrayList.get(position);

        question.setNumber_ticke(numberTicket);
        question.setQuestion(questionText);
        question.setStatus(questionStatus);
        question.setAnswer(questionAnswer);

        Utils.questionAppDatabase.getQuestionDAO().updateQuestion(question);
        questionsArrayList.set(position, question);
    }

    private void deleteQuestion(Question question, int position){
        questionsArrayList.remove(position);
        Utils.questionAppDatabase.getQuestionDAO().deleteQuestion(question);
    }

    private void temp2(){
        ArrayList<String> t = new ArrayList<>();
        t.add("Дать определение «Техническое обслуживание». (ПТБ гл.1 п.43)");
        t.add("Что не допускается делать в аккумуляторном помещении? (ПТЭ гл.16 п.365)");
        t.add("Кто назначается производителем работ, за что отвечает производитель работ? (ПTБ\n" +
                "гл.3 п.38)");
        t.add(" Что применяется для временного ограждения токоведущих частей, оставшихся под\n" +
                "напряжением, какие плакаты безопасности вывешиваются на временных\n" +
                "ограждениях? (ПTБ гл.15 п.168)\n");
        t.add("Первая медицинская помощь при поражении электрическим током.");

        t.add("Дать определение «охранная зона кабельных линий электропередачи и кабельных\n" +
                "линий связи». (ПТБ гл.1 п.26)");
        t.add("Как присоединяются части электроустановок к сети заземления? Как выполняются\n" +
                "присоединения заземляющих проводников к заземлителю и к заземляющим\n" +
                "конструкциям? (ПТЭ гл.13 п. 308,310)");
        t.add("Кто назначается допускающим, за что отвечает допускающий? (ПTБ гл.3 п. 37)");
        t.add("Установка заземлений в распределительных устройствах напряжением до 1000В.\n" +
                "(ПТБ гл.15 п.152,155)");
        t.add("Первая помощь пострадавшему при термических ожогах.");

        t.add("Дать определение «электротехнический персонал» и «электротехнологический\n" +
                "персонал». (ПTБ гл.1 п.58,59)");
        t.add("Какие знаки и надписи наносятся на электродвигатели и пускорегулирующие\n" +
                "устройства? (ПТЭ гл.11п. 252,253)");
        t.add("Правила временного ухода и возврата на рабочее место членов бригады. (ПТБ гл.10\n" +
                "п.111)");
        t.add("Меры безопасности при выполнение работ на электродвигатели или приводимом\n" +
                "им в движение механизме. (ПТБ гл.16 п.199)");
        t.add("Первая медицинская помощь при ранениях.");

        t.add("Дать определение «Наряд допуск». (ПTБ гл.1 п.39)");
        t.add("Порядок включение электрооборудования, отключенного по заявке\n" +
                "технологического персонала. (ПТЭ гл.3 п.44)");
        t.add("За что отвечает наблюдающий? (ПTБ гл.3 п.39)");
        t.add("Меры безопасности при выполнение работ под напряжением в электроустановках\n" +
                "до 1000 В (ПTБ гл. 16 п. 180)");
        t.add("Первая медицинская помощь при кровотечениях.");

        t.add("Дать определение «Персонал оперативно-ремонтный». (ПTБ гл.1 п.14)\n");
        t.add("На что обращается особое внимание при осмотре РУ? (ПТЭ гл.8 п.190)");
        t.add("Порядок оформления перерывов в работе в течение рабочего дня. (ПTБ гл.12 п.119)");
        t.add("В каких случаях допускается временное снятие заземлений. (ПТБ гл.15 п.153)");
        t.add("Первая медицинская помощь при переломах, вывихах, ушибах и растяжения связок.");

        t.add("Дать определение «Персонал оперативный». (ПTБ гл.1 п.15)");
        t.add("В каких случаях электродвигатели должны быть немедленно отключены от сети?\n" +
                "(ПТЭ гл.11 п.268)\n");
        t.add("Порядок включения электроустановок оперативным персоналом после полного\n" +
                "окончания работ. (ПТБ гл.14 п.127)");
        t.add("Чем и как проверяется отсутствие напряжения в электроустановках до 1000 В с\n" +
                "заземленной нейтралью? (ПTБ гл.15 п.139, 144)\n");
        t.add("Первая медицинская помощь при попадании инородных тел");

        t.add("Дать определение «Действующая электроустановка». (ПTБ гл.1 п.32)");
        t.add("Дать определение «текущий ремонт». (ПТЭ гл.1 п.2.1)");
        t.add("Кто является ответственными за безопасное проведение работ? (ПTБ гл.3 п.31)");
        t.add("Перечислить места вывешивания запрещающих плакатов. (ПTБ гл.15 п.137)");
        t.add("Первая медицинская помощь при обморожениях.\n");

        t.add("Дать определение «Электроустановка». (ПТБ гл.1 п.51)");
        t.add("Допустимое напряжение на шинах распределительных устройств при работе\n" +
                "электродвигателей. (ПТЭ гл.11 п.261)\n");
        t.add("За что отвечает член бригады? (ПTБ гл.3 п.40)");
        t.add("Где и для чего в электроустановках должны быть вывешены знаки (плакаты)? (ПTБ\n" +
                "гл.15 п.167)\n");
        t.add("Первая доврачебная медицинская помощь при химических ожогах.");

        t.add("Дать определение «Распоряжение». (ПTБ гл.1 п.40)");
        t.add("Порядок при переключениях в электроустановках. (ПТЭ гл.3 п.46)");
        t.add("Какие работы относятся к выполняемым в порядке текущей эксплуатации? (ПTБ гл.6\n" +
                "п.90)");
        t.add("Порядок установки и снятия переносных заземлений. (ПTБ гл.15 п.146, 147)");
        t.add("Первая доврачебная медицинская помощь при тепловом и солнечном ударе.");

        t.add("Дать определение «Работы, выполняемые в порядке текущей эксплуатации». (ПTБ\n" +
                "гл.1 п.2)");
        t.add("Что входит в объем ежесменного технического обслуживания? (ПТЭ гл.5 п.80)");
        t.add("Где и какие работы допускается выполнять единолично производителю работ с\n" +
                "группой IV? (ПTБ гл.5 п.73)");
        t.add("Меры безопасности при выполнение работ под напряжением в электроустановках\n" +
                "до 1000 В (ПTБ гл. 16 п. 180)");
        t.add("Первая медицинская помощь при отравлениях.");

        t.add("Дать определение «Подготовка рабочего места». (ПTБ гл.1 п.20)");
        t.add("Минимальные расстояния до КЛ при проведение работ землеройными (ударными,\n" +
                "вибропогружными) механизмами. (ПТЭ гл.10 п.245)");
        t.add("Как передается и где регистрируется разрешение на подготовку рабочего места?\n" +
                "(ПTБ гл.8 п.93,94)\n");
        t.add("Что должно быть отключено при подготовке рабочего места? (ПTБ гл.15 п.131,135)");
        t.add("Первая медицинская помощь при отравлении нефтяными газами.");

        t.add("Дать определение «Персонал ремонтный». (ПTБ гл.1 п.19)");
        t.add("В чем заключается оперативное обслуживание электроустановок? (ПТЭ гл.3 п.28)");
        t.add("Когда и кто проводит целевой инструктаж при работах по наряду? (ПTБ гл.9 п.102)");
        t.add("Перечислить технические мероприятия, обеспечивающие безопасность работ со\n" +
                "снятием напряжения. (ПTБ гл.15 п.130)\n");
        t.add("Действия очевидца или пострадавшего согласно утвержденной схеме");

        t.add("Дать определение «Заземление», «Защитное заземление». (ПTБ гл.1 п.16, 33)");
        t.add("Что наносится на щиты и сборки сети освещения на лицевой и внутренней стороне?\n" +
                "(ПТЭ гл.18 п.398, 399)");
        t.add("Правила учета, хранения и выдачи ключей от электроустановок. (ПTБ гл.2 п.27)");
        t.add("Где допускается устанавливать заземления при работе на эл. двигателях? (ПTБ гл.16\n" +
                "п.200)");
        t.add("Что такое шаговое напряжение? Действия человека оказавшегося в зоне действия\n" +
                "шагового напряжения? ");

        t.add("Дать определение «Комплектное распределительное устройство». (ПTБ гл.1 п.17)");
        t.add("Кто допускается к работе с использованием переносных и передвижных\n" +
                "электроприемников. Кто назначается для проведения периодических проверок\n" +
                "переносных электроприемников и вспомогательного оборудования к ним. Его\n" +
                "обязанности? (ПТЭ гл.22 п.512,516,517)");
        t.add("Кто может выполнять единоличный осмотр электроустановок? (ПTБ гл.2 п.19, 20)");
        t.add("Заполнение наряда-допуска для работы в электроустановках. (ПTБ прил. 3)");
        t.add("В каких случаях проводят внеплановый инструктаж?\n");

        t.add("Дать определение «Категория работ». (ПTБ гл.1 п.21)");
        t.add("Какое должно применяться напряжение в особо опасных и помещениях с\n" +
                "повышенной опасностью для питания переносных (ручных) светильников, ламп,\n" +
                "вилки приборов и трансформаторов? (ПТЭ гл.18 п.402)\n");
        t.add("Организация техники безопасности при эксплуатации электроустановок\n" +
                "потребителей. (ПTБ гл.3 п.30)");
        t.add("Меры безопасности при измерении мегомметром в процессе эксплуатации? (ПTБ\n" +
                "гл.30 п.493,494,495)");
        t.add("Дать определение что такое Основные и дополнительные средства защиты.");

        ArrayList<String> q = new ArrayList<>();
        q.add("Комплекс операций или операция по поддержанию работоспособности или\n" +
                "исправности изделия при использовании по назначению, ожидании, хранении и\n" +
                "транспортировании");
        q.add("Не допускаются курение в аккумуляторном помещении, вход в него с огнем,\n" +
                "пользование электронагревательными приборами, аппаратами и инструментами, которые\n" +
                "дают искру.");
        q.add("Производитель работ отвечает за:\n" +
                "1. соответствие рабочего места указаниям наряда, обеспечение мер безопасности,\n" +
                "необходимых по условиям выполнения работ;\n" +
                "2. четкость и полноту инструктажа членов бригады;\n" +
                "3. наличие, исправность и правильное применение средств защиты, инструментов,\n" +
                "инвентаря и приспособлений;\n" +
                "4. сохранность на рабочем месте ограждений, плакатов, запирающих устройств\n" +
                "приводов;\n" +
                "5. безопасное проведение работы и соблюдение настоящих Правил им самим и членами\n" +
                "бригады;\n" +
                "6. осуществление постоянного контроля над членами бригады.\n" +
                "Производитель работ, выполняемых по наряду в электроустановках напряжением\n" +
                "выше 1000 В, имеет IV группу по электробезопасности, а в электроустановках напряжением\n" +
                "до 1000 В – III группу.\n" +
                "Для работ в подземных сооружениях, где возможно появление вредных газов, работ\n" +
                "под напряжением и по перетяжке, замене проводов на ВЛ напряжением до 1000 В,\n" +
                "подвешенных на опорах ВЛ напряжением выше 1000 В, производитель работ имеет IV группу\n" +
                "по электробезопасности.\n" +
                "Для выполнения работ по распоряжению в электроустановках напряжением до и\n" +
                "выше 1000 В, кроме работ, указанных в пункте 193 настоящих Правил, достаточным является\n" +
                "наличие у производителя работ III группы по электробезопасности.");
        q.add("Для временного ограждения токоведущих частей, оставшихся под напряжением,\n" +
                "применяются щиты, ширмы, экраны, изготовленные из изоляционных материалов.\n" +
                "При установке временных ограждений без снятия напряжения расстояние от них до\n" +
                "токоведущих частей должно быть не менее указанного в таблице 1 приложения 2 к\n" +
                "настоящим Правилам. В электроустановках напряжением 6-10 кВ это расстояние разрешается\n" +
                "уменьшить до 0,35 м.\n" +
                "На временные ограждения наносятся знаки (плакаты) «СТОЙ! НАПРЯЖЕНИЕ» по\n" +
                "форме согласно приложению 9 к настоящим Правилам или укрепляются соответствующие\n" +
                "плакаты.\n");
        q.add("Пострадавшего нужно немедленно освободить от действия электрического тока.\n" +
                "Самым лучшим способом является быстрое отключение той части электроустановки,\n" +
                "которой касается пострадавший. Однако в условиях больших промышленных предприятий\n" +
                "это не всегда возможно. Тогда необходимо отбросить электропровод или перерубить\n" +
                "топором с сухой деревянной ручкой, либо оттащить пострадавшего от источника тока.\n" +
                "При этом необходимо соблюдать меры личной предосторожности: использовать\n" +
                "резиновые перчатки, сапоги, галоши, резиновые коврики, подстилки из сухого дерева,\n" +
                "деревянные сухие палки и т.п. При оттаскивании пострадавшего от кабеля, проводов и т.п.\n" +
                "следует браться за его одежду (если она сухая!), а не за тело, которое в это время является\n" +
                "проводником электричества.\n" +
                "Затем необходимо немедленно сообщить о несчастном случае руководителю объекта,\n" +
                "подразделения и диспетчеру, согласно утвержденной схемы оповещения.\n" +
                "После освобождения пострадавшего, если он находится в сознании, следует уложить в\n" +
                "удобное положение, тепло укрыть, дать 20-25 капель валериановой настойки, теплый чай\n" +
                "или кофе и до прибытия врача обеспечить покой, наблюдая за дыханием и пульсом.\n" +
                "Если пострадавший находится в бессознательном состоянии, но с устойчивым\n" +
                "дыханием и пульсом, его следует ровно и удобно уложить, расстегнуть одежду, создать\n" +
                "приток свежего воздуха, давать нюхать нашатырный спирт, обрызгать его водой и\n" +
                "обеспечить полный покой.\n" +
                "Если у пострадавшего отсутствует дыхание и пульс или он дышит очень редко и\n" +
                "судорожно, то ему следует делать искусственное дыхание и массаж сердца. Самым\n" +
                "эффективным является способ «рот в рот», проводимый одновременно с непрямым\n" +
                "массажем сердца. Начинать искусственное дыхание следует немедленно после\n" +
                "освобождения пострадавшего от электрического тока и осуществлять непрерывно до\n" +
                "прибытия врача.");

        q.add("Участок земли вдоль подземных кабельных линий, ограниченный вертикальными\n" +
                "плоскостями, отстоящими по обе стороны линии от крайних кабелей на расстоянии 1 м для\n" +
                "КЛ и 2 м для КЛС, а для кабельных линий напряжением до 1000 В, проходящих в городах под\n" +
                "тротуарами, на расстоянии 0,6 м и 1 м соответственно в сторону проезжей части улицы и\n" +
                "противоположную сторону.");
        q.add("Присоединение заземляющих проводников к заземлителю и заземляющим\n" +
                "конструкциям выполняется сваркой, а к главному заземляющему зажиму, корпусам\n" +
                "аппаратов, машин и опорам воздушных линий – болтовым соединением (для обеспечения\n" +
                "возможности производства измерений).\n" +
                "Каждая часть электроустановки, подлежащая заземлению или занулению,\n" +
                "присоединяется к сети заземления или зануления с помощью отдельного проводника.\n" +
                "Последовательное соединение заземляющими (зануляющими) проводниками нескольких\n" +
                "элементов электроустановки не допускается.\n" +
                "Сечение заземляющих и нулевых защитных проводников выполняется в соответствие с\n" +
                "законодательством Республики Казахстан в области электроэнергетики.");
        q.add("Допускающий отвечает за:\n" +
                "1. правильное и точное выполнение технических мероприятий по подготовке рабочего\n" +
                "места, указанного в наряде, распоряжении, соответствие технических мероприятий\n" +
                "характеру и месту работы;\n" +
                "2. правильный допуск к работе;\n" +
                "3. полноту и качество проведенного им инструктажа членов бригады.\n" +
                "Допускающих назначают из числа оперативного персонала. В электроустановках\n" +
                "напряжением выше 1000 В допускающий имеет IV группу по электробезопасности, а\n" +
                "электроустановках до 1000 В– III группу");
        q.add("В электроустановках напряжением до 1000 В при работах на сборных шинах РУ, щитов,\n" +
                "сборок напряжение с шин снимается и шины (за исключением шин, выполненных\n" +
                "изолированным проводом) заземляются. Необходимость и возможность заземления\n" +
                "присоединений этих РУ, щитов, сборок и подключенного к ним оборудования определяет\n" +
                "выдающий наряд, распоряжение.\n" +
                "В электроустановках напряжением до 1000 В операции по установке и снятию\n" +
                "заземлений разрешается выполнять одному работнику, имеющему группу III из числа\n" +
                "оперативного персонала.");
        q.add("При ограниченном термическом ожоге следует немедленно начать охлаждение\n" +
                "места ожога водопроводной водой в течение 10-15 минут. После этого на область ожога наложить чистую, лучше стерильную повязку. Для уменьшения боли применять обезболивающие средства (анальгин, амидопирин и др.).\n" +
                "При обширных ожогах, после наложения повязок, напоить пострадавшего горячим\n" +
                "чаем. Дать обезболивающее средство и тепло, укутав, срочно доставить его в лечебное\n" +
                "учреждение. Если перевозка задерживается или длится долго, то надо дать пострадавшему\n" +
                "выпить щелочно-солевую смесь (1 чайная ложка поваренной соли и 1 /2 чайной ложки\n" +
                "пищевой соды, растворенные в 2 стаканах воды). В первые 6 ч после ожога пострадавший\n" +
                "должен получать не менее 2 стаканов раствора в течение часа\n");

        q.add("Электротехнический персонал – административно-технический, оперативный,\n" +
                "оперативно-ремонтный, ремонтный персонал, осуществляющий монтаж, наладку,\n" +
                "техническое обслуживание, ремонт, управление режимом работы электроустановок.\n" +
                "Электротехнологический персонал – персонал, у которого в управляемом\n" +
                "технологическом процессе основной составляющей является электрическая энергия\n" +
                "(например, электросварка, электродуговые печи, электролиз), использующий в работе\n" +
                "ручные электрические машины, переносной электроинструмент и светильники и другие\n" +
                "работники для которых должностной инструкцией установлено знание настоящих Правил.\n");
        q.add("На электродвигатели и приводимые ими механизмы наносятся стрелки, указывающие\n" +
                "направление вращения.\n" +
                "На электродвигателях и пускорегулирующих устройствах выполняются надписи с\n" +
                "наименованием агрегата и механизма, к которому они относятся.");
        q.add("Допускается с разрешения производителя работ (наблюдающего) временный уход с\n" +
                "рабочего места одного или нескольких членов бригады. При этом выводить их из состава\n" +
                "бригады не требуется. В электроустановках напряжением выше 1000 В количество членов\n" +
                "бригады, оставшихся на рабочем месте, составляет не менее двух, включая производителя\n" +
                "работ (наблюдающего).\n" +
                "Членам бригады, имеющим III группу по электробезопасности, разрешается\n" +
                "самостоятельно выходить из РУ и возвращаться на рабочее место; члены бригады, имеющие\n" +
                "II группу – в сопровождении члена бригады, имеющего III группу, или работника, имеющего \n" +
                "право единоличного осмотра электроустановок. Не допускается после выхода из РУ\n" +
                "оставлять дверь не запертой на замок.\n" +
                "Возвратившиеся члены бригады приступают к работе с разрешения производителя\n" +
                "работ (наблюдающего).\n");
        q.add("В тех случаях, когда работа на электродвигателе или приводимом им в движение\n" +
                "механизме связана с прикосновением к токоведущим вращающимся частям,\n" +
                "электродвигатель отключается с выполнением предусмотренных настоящими Правилами\n" +
                "технических мероприятий, предотвращающих его ошибочное включение. При этом у\n" +
                "двухскоростного электродвигателя отключают и разбирают обе цепи питания обмоток\n" +
                "статора.\n" +
                "Работу не связанную с прикосновением к токоведущим или вращающимся частям\n" +
                "электродвигателя и приводимого им в движение механизма, допускается производить на\n" +
                "работающем электродвигателе.\n" +
                "Не допускается снимать ограждения вращающихся частей работающих\n" +
                "электродвигателя и механизма.\n");
        q.add("Первая помощь при ранениях заключается в остановке кровотечения и\n" +
                "предохранения раны от заражения. При этом необходимо соблюдать следующие правила:\n" +
                "1. оказывающий первую помощь должен вымыть руки или смазать пальцы йодной\n" +
                "настойкой либо спиртовым раствором;\n" +
                "2. не разрешается промывать рану водой или каким-либо лекарственным веществом,\n" +
                "засыпать порошками и покрывать мазями;\n" +
                "3. не разрешается удалять с раны песок, землю и т.п.;\n" +
                "4. не допускается удаление из раны сгустков крови.\n" +
                "При ранении на рану необходимо наложить стерильный перевязочный материал,\n" +
                "затем рану перевязать бинтом");

        q.add("Наряд-допуск – задание на производство работы, оформленное на специальном\n" +
                "бланке установленной формы и определяющее содержание, место работы, время ее начала\n" +
                "и окончания, условия безопасного проведения, состав бригады и лиц, ответственных за\n" +
                "безопасное выполнение работы.\n");
        q.add("Электрооборудование, отключенное по устной заявке технологического персонала для\n" +
                "производства каких-либо работ, включается по требованию работника, давшего заявку на\n" +
                "отключение или заменяющего его.\n" +
                "Перед пуском оборудования, временно отключенного по заявке технологического\n" +
                "персонала, оперативный персонал осматривает оборудование, убеждается в его готовности к\n" +
                "включению под напряжение и предупреждает работающий на нем персонал о предстоящем\n" +
                "включении.\n" +
                "Порядок оформления заявок на отключение и включение электрооборудования\n" +
                "утверждается ответственным за электроустановки потребителя.\n");
        q.add("Наблюдающий осуществляет надзор за бригадой работников, не имеющих допуска\n" +
                "самостоятельно работать в электроустановках.\n" +
                "Наблюдающий отвечает за:\n" +
                "1. соответствие подготовленного рабочего места указаниям, предусмотренным в наряде;\n" +
                "2. наличие и сохранность установленных на рабочем месте заземлений, ограждений,\n" +
                "плакатов и знаков безопасности, запирающих устройств приводов;\n" +
                "3. безопасность членов бригады в отношении поражения электрическим током\n" +
                "электроустановки и от других производственных факторов.\n" +
                "Ответственным за безопасность, связанную с технологией работы, является работник,\n" +
                "возглавляющий бригаду, который входит в ее состав и должен постоянно находиться на\n" +
                "рабочем месте. Его фамилия указывается в строке «Отдельные указания» наряда.");
        q.add("В электроустановках напряжением до 1000 В при работе под напряжением\n" +
                "необходимо:\n" +
                "1. оградить расположенные вблизи рабочего места другие токоведущие части,\n" +
                "находящиеся под напряжением, к которым возможно случайное прикосновение;\n" +
                "2. работать в диэлектрических галошах или стоя на изолирующей подставке либо на\n" +
                "диэлектрическом резиновом коврике;\n" +
                "3. применять инструмент с изолирующими рукоятками (у отверток, кроме того,\n" +
                "изолируется стержень), пользоваться диэлектрическими перчатками.\n" +
                "При работе под напряжением не допускается работать в одежде с короткими или\n" +
                "засученными рукавами, а также пользоваться ножом, напильниками, металлическими\n" +
                "линейками.\n");
        q.add("Кровотечения - в зависимости от локализации выделяют наружное и внутреннее\n" +
                "кровотечение, по типу повреждённого сосуда – капиллярное, артериальное и венозное.\n" +
                "Первая доврачебная помощь при капиллярном кровотечении: капиллярное\n" +
                "кровотечение, как правило, не сопровождается значительной кровопотерей и достаточно \n" +
                "легко останавливается. Признаком повреждения мелких кровеносных сосудов (капилляров)\n" +
                "является то, что кровоточит вся раневая поверхность, однако не слишком обильно (как\n" +
                "губка). При кровотечениях данного типа необходимо обработать края раны\n" +
                "спиртосодержащим антисептиком (йодной настойкой, например) и наложить асептическую\n" +
                "марлевую повязку. В таком случае на саму рану под повязку накладывают вату. Следует\n" +
                "помнить, что повязка не должна быть тугой.\n" +
                "Первая доврачебная помощь при венозном кровотечении: признаком венозного\n" +
                "кровотечения является тёмный цвет крови, вытекающей с большой скоростью, однако\n" +
                "равномерной струей (без пульсации, фонтанирования). Кроме того, возможно образование\n" +
                "кровяных сгустков, которые ни в коем случае нельзя удалять, так как это спровоцирует\n" +
                "усиление кровопотери. В качестве первой помощи при кровотечениях из венозных сосудов\n" +
                "на рану накладывают давящую асептическую повязку. При неэффективности указанного\n" +
                "метода необходимо наложить жгут ниже места повреждения. При этом под жгут кладут\n" +
                "мягкую прокладку, чтобы избежать дополнительной травматизации кожи и мягких тканей, а\n" +
                "также записку с указанием времени наложения жгута. Максимальное время, на протяжении\n" +
                "которого жгут может не сниматься, составляет 1 час в условиях холода (зимой) и до 2 часов в\n" +
                "теплое время года. Превышение данного временного лимита может приводить к отмиранию\n" +
                "тканей обескровленной конечности. При отсутствии жгута возможно использование закрутки\n" +
                "(закручивание полотенца, бинта, пояса, галстука или любой подручной ткани с помощью\n" +
                "короткой палки, ручки и т.п.). Временные рамки остаются те же.\n" +
                "Первая доврачебная помощь при артериальном кровотечении: это наиболее опасное\n" +
                "кровотечение, нежели капиллярное и венозное. Признаком повреждения артерии является\n" +
                "ярко-алый цвет крови, вытекающей с большой скоростью пульсирующей струей (пульсация\n" +
                "в такт сердечным сокращениям), а при повреждении крупных артерий кровь может бить\n" +
                "фонтаном, прерывисто. Первая помощь заключается в поднятии конечности (если нет\n" +
                "переломов) и наложении кровоостанавливающего жгута выше места повреждения (ближе к\n" +
                "туловищу). Также можно использовать закрутку. Временные ограничения такие же, как и при\n" +
                "венозном кровотечении. При отсутствии жгута и закрутки (или их поисках) необходимо\n" +
                "остановить кровотечение пальцевым прижатием артерии выше повреждённого участка (в\n" +
                "точке пульсации). При кровотечении из бедренной, подколенной, локтевой и плечевой\n" +
                "артерий возможна также фиксация максимально согнутой конечности в приподнятом\n" +
                "положении.\n" +
                "Во всех случаях и видах кровотечении необходимо самостоятельно или при помощи\n" +
                "других вызвать бригаду скорой помощи. Прикасаться к ране руками, промывать рану в\n" +
                "случае попадания в неё ржавчины, песка и т.п. нельзя (это может нанести ещё больший вред\n" +
                "и усилить кровотечение), также нельзя удалять из раны осколки стекла и т.п. Не\n" +
                "рекомендуется допускать попадания йодного раствора внутрь раны.");

        q.add("Оперативно-ремонтный персонал – ремонтный персонал, специально обученный и\n" +
                "подготовленный для оперативного обслуживания в утвержденном объеме закрепленных за\n" +
                "ним электроустановок.");
        q.add("При осмотре распределительных устройств особое внимание необходимо обратить на\n" +
                "следующее:\n" +
                "1. состояние помещения, исправность дверей и окон, отсутствие течи в кровле и\n" +
                "междуэтажных перекрытиях, наличие и исправность запоров и замков;\n" +
                "2. исправность отопления и вентиляции, освещения и сети заземления;\n" +
                "3. наличие средств пожаротушения;\n" +
                "4. наличие испытанных защитных средств и их укомплектованность;\n" +
                "5. укомплектованность медицинской аптечки;\n" +
                "6. уровень и температура масла, отсутствие течи в аппаратах;\n" +
                "7. состояние контактов, рубильников щита низкого напряжения;\n" +
                "8. целостность пломб у электросчетчиков;\n" +
                "9. состояние изоляции (запыленность, наличие трещин, разрядов и т.п.);\n" +
                "10. отсутствие повреждений и следов коррозии, вибрации и треска\n" +
                "у элегазового оборудования;\n" +
                "11. работу системы сигнализации;\n" +
                "12. давление воздуха в баках воздушных выключателей;\n" +
                "13. давление сжатого воздуха в резервуарах пневматических приводов выключателей;\n" +
                "14. отсутствие утечек воздуха;\n" +
                "15. исправность и правильность показаний указателей положения выключателей;\n" +
                "16. наличие вентиляции полюсов воздушных выключателей;\n" +
                "17. отсутствие течи масла из конденсаторов емкостных делителей напряжения воздушных\n" +
                "выключателей;\n" +
                "18. действие устройства электроподогрева в холодное время года;\n" +
                "19. плотность закрытия шкафов управления;\n" +
                "20. возможность легкого доступа к коммутационным аппаратам и др.;\n" +
                "21. отсутствие высокого травостоя и исправность дренажных устройств открытых\n" +
                "распределительных устройств.");
        q.add("При перерыве в работе на протяжении рабочего дня (на обед, по условиям работы)\n" +
                "бригада удаляется с рабочего места, а двери РУ запираются на замок.\n" +
                "Наряд остается у производителя работ (наблюдающего). Членам бригады не\n" +
                "допускается возвращаться после перерыва на рабочее место без производителя работ\n" +
                "(наблюдающего). Допуск к работам после перерыва осуществляется производителем работ\n" +
                "(наблюдающий) без оформления в наряде.");
        q.add("Допускается временное снятие заземлений, установленных при подготовке рабочего\n" +
                "места, в зависимости от характера выполняемых работ (измерение сопротивления изоляции).\n" +
                "Временное снятие и повторная установка заземлений выполняются оперативным\n" +
                "персоналом либо, по указанию выдающего наряд, производителем работ.\n" +
                "Разрешение на временное снятие заземлений, а также на выполнение этих операций\n" +
                "производителем работ вносится в строку наряда «Отдельные указания» в таблице 1 \n" +
                "приложении 3 к настоящим Правилам с записью о том, где и для какой цели снимаются\n" +
                "заземления");
        q.add("При переломах и вывихах основной задачей является обеспечение спокойного и\n" +
                "наиболее удобного положения для поврежденной конечности, что достигается полной ее\n" +
                "неподвижностью.\n" +
                "При переломе черепа необходимо прикладывать к голове пострадавшего холодные\n" +
                "предметы (резиновый пузырь со льдом или холодной водой, холодные примочки и т.п.).\n" +
                "При переломе позвоночника следует, не поднимая пострадавшего, подсунуть под него\n" +
                "доску или повернуть его на живот, следя, чтобы туловище его не перегибалось.\n" +
                "При переломе и вывихе ключицы необходимо:\n" +
                "o положить в подмышечную впадину поврежденной стороны небольшой комок ваты,\n" +
                "марли или какой-либо материи;\n" +
                "o согнутую в локте под прямым углом руку прибинтовать к туловищу;\n" +
                "o руку ниже локтя подвязать косынкой к шее.\n" +
                "При переломе и вывихе костей рук наложить соответствующие шины. При отсутствии\n" +
                "шин руку следует подвесить на косынке к шее, а затем прибинтовать ее к туловищу, не\n" +
                "подкладывая комка в подмышечную впадину.\n" +
                "При переломе и вывихе костей кисти и пальцев рук следует прибинтовать кисть руки к\n" +
                "широкой шине так, чтобы шина начиналась от середины предплечья, а кончалась у конца\n" +
                "пальцев. В ладонь поврежденной руки должен быть предварительно вложен комок ваты,\n" +
                "бинт и т.п., чтобы пальцы были несколько согнуты.\n" +
                "При переломе и вывихе нижних конечностей необходимо укрепить больную\n" +
                "конечность шиной, фанерной пластинкой, палкой, картоном или каким-либо другим\n" +
                "подобным предметом так, чтобы один конец пластинки заходил выше края таза до\n" +
                "подмышки, а другой достигал пятки. Внутренняя шина располагается от паха до пятки. По\n" +
                "возможности шину следует накладывать, не приподнимая ноги, а придерживая ее на месте, и\n" +
                "проталкивать повязку палочкой под поясницей, коленом или пяткой.\n" +
                "При переломе ребер туго забинтовать грудь или стянуть ее полотенцем во время\n" +
                "выдоха");

        q.add("Оперативный персонал – персонал, осуществляющий оперативное управление и\n" +
                "обслуживание электроустановок (осмотр, оперативные переключения, подготовку рабочего\n" +
                "места, допуск и надзор за работающими, выполнение работ в порядке текущей\n" +
                "эксплуатации).");
        q.add("Электродвигатели немедленно отключают от сети при:\n" +
                "1. несчастных случаях с людьми;\n" +
                "2. появлении дыма или огня из корпуса электродвигателя, а также из его\n" +
                "пускорегулирующей аппаратуры и устройства возбуждения;\n" +
                "3. поломке приводного механизма;\n" +
                "4. резком увеличении вибрации подшипников агрегата;\n" +
                "5. нагреве подшипников сверх допустимой температуры, установленной в инструкции\n" +
                "завода-изготовителя.\n" +
                "В эксплуатационных инструкциях указываются и другие случаи, при которых\n" +
                "электродвигатели немедленно отключают, а также определяют порядок устранения\n" +
                "аварийного состояния и пуска электродвигателей.");
        q.add("Работник из числа оперативного персонала, получивший разрешение (распоряжение)\n" +
                "на включение электроустановки после полного окончания работ, перед включением\n" +
                "убеждается в готовности электроустановки к включению (проверяет чистоту рабочего места,\n" +
                "отсутствие инструмента), снимает временные ограждения, переносные плакаты безопасности\n" +
                "и заземления, установленные при подготовке рабочего места оперативным персоналом,\n" +
                "восстанавливает постоянные ограждения.\n");
        q.add("Проверять отсутствие напряжения в электроустановке необходимо указателем\n" +
                "напряжения, исправность которого перед применением устанавливается с помощью\n" +
                "предназначенных для этой цели специальных приборов, или приближением к токоведущим\n" +
                "частям, заведомо находящимся под напряжением.\n" +
                "В электроустановках напряжением выше 1000 В пользоваться указателем напряжения\n" +
                "необходимо в диэлектрических перчатках.\n" +
                "В электроустановках напряжением 35 кВ и выше для проверки отсутствия напряжения\n" +
                "допускается использование изолирующей штанги путем прикосновения ею несколько раз к\n" +
                "токоведущим частям. Признаком отсутствия напряжения является отсутствие искрения и\n" +
                "потрескивания.\n" +
                "В электроустановках напряжением до 1000 В с заземленной нейтралью при\n" +
                "применении двухполюсного указателя проверка отсутствия напряжения выполняется между\n" +
                "фазами и между каждой фазой и заземленным корпусом оборудования или защитным\n" +
                "проводником. Допускается применять предварительно проверенный вольтметр. Не\n" +
                "допускается пользоваться контрольными лампами.");
        q.add("При попадании инородного тела в дыхательное горло необходимо:\n" +
                "- попросить пострадавшего сделать несколько резких кашлевых толчков;\n" +
                "- нанести пострадавшему 3 - 5 коротких ударов кистью в межлопаточную область\n" +
                "при наклоненной вниз голове или в положении лежа на животе;\n" +
                "- охватить пострадавшего сзади, сцепив кисти рук между мечевидным отростком\n" +
                "грудины и пупком и произвести 3 - 5 быстрых надавливаний на живот\n" +
                "пострадавшего.\n" +
                "Инородные тела, попавшие в глаз, следует удалять промыванием струей раствора\n" +
                "борной кислоты или чистой водой. Промывать необходимо от наружного угла глаза\n" +
                "(от виска) к внутреннему (к носу). Тереть глаз не разрешается.\n" +
                "При попадании инородных тел в мягкие ткани (под кожу, ноготь и т.п.) необходимо:\n" +
                "- удалить инородное тело (если есть уверенность, что это можно сделать);\n" +
                "- обработать место внедрения инородного тела раствором йода;\n" +
                "- наложить стерильную повязку.\n");

        q.add("Действующая электроустановка – электроустановка или ее часть, которая находится\n" +
                "под напряжением, либо на которую напряжение может быть подано включением\n" +
                "коммутационных аппаратов.");
        q.add("Текущий ремонт – это плановый ремонт, осуществляемый на месте установки\n" +
                "электрооборудования эксплуатационным персоналом или ремонтной бригадой в процессе\n" +
                "эксплуатации с целью гарантированного обеспечения нормальной работы\n" +
                "электрооборудования и сетей до очередного ремонта и предусматривающий осмотр,\n" +
                "очистку, уплотнение, устранение отдельных неисправностей, замену или восстановление\n" +
                "изношенных деталей, узлов и регулировку механизмов, проведение профилактических\n" +
                "мероприятий.");
        q.add("Ответственными за безопасное проведение работ являются:\n" +
                "1. лицо, выдающее наряд, распоряжение, утверждающее перечень работ,\n" +
                "выполняемых в порядке текущей эксплуатации;\n" +
                "2. ответственный руководитель работ;\n" +
                "3. выдающий разрешение на допуск на рабочее место;\n" +
                "4. допускающий на рабочее место;\n" +
                "5. производитель работ;\n" +
                "6. наблюдающий;\n" +
                "7. член бригады.\n");
        q.add("На приводах (рукоятках приводов) коммутационных аппаратов с ручным управлением\n" +
                "(выключателей, комбинированных выключателей, отделителей, разъединителей,\n" +
                "рубильников, автоматов) во избежание подачи напряжения на рабочее место вывешиваются\n" +
                "знаки (плакаты) «НЕ ВКЛЮЧАТЬ работают люди» по форме согласно приложению 6 к\n" +
                "настоящим Правилам.\n" +
                "У однополюсных разъединителей плакаты вывешиваются на приводе каждого полюса,\n" +
                "а у разъединителей, управляемых оперативной штангой, - на ограждениях. На задвижках,\n" +
                "закрывающих доступ воздуха в пневматические приводы разъединителей, вывешиваются\n" +
                "знаки (плакаты) «НЕ ОТКРЫВАТЬ работают люди» по форме согласно приложению 7 к\n" +
                "настоящим Правилам.\n" +
                "На присоединениях напряжением до 1000 В, не имеющих коммутационных аппаратов,\n" +
                "плакат по форме согласно приложению 6 к настоящим Правилам вывешивается у снятых\n" +
                "предохранителей. В КРУ – в соответствии с пунктом 240 настоящих Правил.\n" +
                "Плакаты вывешиваются на ключах и кнопках дистанционного и местного управления, а\n" +
                "также на автоматах или у места снятых предохранителей цепей управления и силовых цепей\n" +
                "питания приводов коммутационных аппаратов.\n");
        q.add("Обморожения - наступают при длительном воздействии холода на какой-либо участок\n" +
                "тела. Воздействие холода на весь организм вызывает общее охлаждение. При обморожении\n" +
                "на пораженных участках кожа становится холодной, бледно-синюшного цвета,\n" +
                "чувствительность отсутствует. При общем охлаждении пострадавший вял, безучастен,\n" +
                "кожные покровы бледные, холодные, пульс редкий, температура тела меньше 36,5°С.\n" +
                "Первая доврачебная помощь: пострадавшего внести в теплое помещение, снять обувь\n" +
                "и перчатки. Обмороженную конечность вначале растереть сухой тканью, затем поместить в\n" +
                "таз с теплой (32-34,5°С) водой. В течение 10 мин температуру довести до 40,5°С. При\n" +
                "восстановлении чувствительности и кровообращения конечность вытереть насухо, протереть\n" +
                "33% раствором спирта, наложить асептическую или чистую повязку (можно надеть чистые\n" +
                "проглаженные носки или перчатки). При общем охлаждении пострадавшего необходимо\n" +
                "тепло укрыть, обложить грелками, напоить горячим чаем.");

        q.add("Электроустановка – комплекс взаимосвязанного электрического оборудования,\n" +
                "предназначенного для производства, накопления, преобразования, передачи, распределения\n" +
                "или потребления энергии.");
        q.add("Напряжение на шинах распределительных устройств должно поддерживаться в\n" +
                "пределах 100 –105% от номинального значения. Для обеспечения долговечности\n" +
                "электродвигателей использовать их при напряжении выше 110% и ниже 90% от\n" +
                "номинального не рекомендуется.\n" +
                "При изменении частоты питающей сети в пределах +2,5% от номинального значения\n" +
                "допускается работа электродвигателей с номинальной мощностью.\n" +
                "Номинальная мощность электродвигателей должно сохраняться при одновременном\n" +
                "отклонении напряжения до +10% и частоты до +2,5% от номинальных значений при условии,\n" +
                "что при работе с повышенным напряжением и пониженной частотой или с пониженным\n" +
                "напряжением и повышенной частотой сумма абсолютных значений отклонений напряжения\n" +
                "и частоты не превышает 10%.");
        q.add("Каждый член бригады отвечает за:\n" +
                "1. выполнение требований настоящих Правил, инструктивных указаний, полученных\n" +
                "при допуске и во время работы;\n" +
                "2. выполнение инструкций по охране труда соответствующих организаций;\n" +
                "3. наличие, исправность и правильное применение индивидуальных средств защиты,\n" +
                "инструмента, спецодежды.");
        q.add("В электроустановках вывешиваются знаки (плакаты) по форме согласно приложению 5\n" +
                "к настоящим Правилам на приводах разъединителей, отделителей и выключателей нагрузки,\n" +
                "при ошибочном включении которых может быть подано напряжение на заземленный\n" +
                "участок электроустановки, а также на ключах и кнопках дистанционного управления\n" +
                "коммутационными аппаратами.");
        q.add("Химический ожог - при химических ожогах редко возникают пузыри. Углублению и\n" +
                "распространению ожога способствует пропитанная кислотой или щелочью\n" +
                "одежда. Немедленно удалить одежду, пропитанную химикатом. Кожу обильно промыть\n" +
                "проточной водой. Ввести обезболивающее средство и направить пострадавшего в лечебное\n" +
                "учреждение.\n" +
                "Первая доврачебная помощь: при химических ожогах кислотами (серная, азотная,\n" +
                "соляная) пораженное место должно быть немедленно тщательно промыто обильной струей\n" +
                "воды в течение 10-15 мин. После этого пораженное место необходимо промыть 5 %\n" +
                "раствором марганцево-кислого калия или 10% раствором питьевой соды, а при попадании\n" +
                "кислоты в дыхательные пути – дышать распыленным при помощи пульверизатора 5%\n" +
                "раствором питьевой соды.\n" +
                "При химических ожогах едкими щелочами (каустическая сода, негашеная известь)\n" +
                "пораженное место следует тщательно промыть обильной струей воды в течение 10-15 мин,\n" +
                "затем – слабым раствором уксусной кислоты (3 - 6 % по объему) или раствором борной\n" +
                "кислоты (одна чайная ложка на стакан воды). После этого пораженные места покрыть\n" +
                "марлей, пропитанной 5% раствором уксусной кислоты. Если едкая щелочь или ее пары\n" +
                "попадают в глаза и полость рта, пораженные места следует промывать 2% раствором борной\n" +
                "кислоты. И в дальнейшем действовать согласно схемы оповещения. ");

        q.add("Распоряжение – задание на производство работы, определяющее ее содержание,\n" +
                "место, время, меры безопасности (если они требуются) и лиц, которым поручено ее\n" +
                "выполнение, с указанием группы по электробезопасности.");
        q.add("При переключениях в электроустановках необходимо соблюдать следующий порядок:\n" +
                "1. работник, получивший задание на переключения, повторяет его, записывает в\n" +
                "оперативный журнал и устанавливает по оперативной схеме или схеме-макету\n" +
                "порядок предстоящих операций;\n" +
                "2. составить (при необходимости) бланк переключений;\n" +
                "3. переговоры, проводимые оперативным персоналом, осуществляются на языке,\n" +
                "исключающем возможность неправильного понимания персоналом\n" +
                "принимаемых сообщений и передаваемых распоряжений;\n" +
                "4. если переключения выполняют два работника, то тот, кто получил распоряжение,\n" +
                "разъясняет по оперативной схеме соединений второму работнику, участвующему\n" +
                "в переключениях, порядок и последовательность предстоящих операций;\n" +
                "5. при возникновении сомнений в правильности выполнения переключений их\n" +
                "необходимо прекратить и повторно проверить требуемую последовательность по\n" +
                "оперативной схеме соединений;\n" +
                "6. по завершению распоряжения на переключения осуществляется запись в\n" +
                "оперативном журнале.");
        q.add("К работам, выполняемым в порядке текущей эксплуатации в электроустановках\n" +
                "напряжением до 1000 В относятся:\n" +
                "1. работы в электроустановках с односторонним питанием;\n" +
                "2. отсоединение, присоединение кабеля, проводов электродвигателя, другого\n" +
                "оборудования;\n" +
                "3. ремонт магнитных пускателей, рубильников, контакторов, пусковых кнопок, другой\n" +
                "аналогичной пусковой и коммутационной аппаратуры при условии установки ее вне\n" +
                "щитов и сборок;\n" +
                "4. ремонт отдельных электроприемников (электродвигателей, электрокалориферов);\n" +
                "5. ремонт отдельно расположенных магнитных станций и блоков управления, уход за\n" +
                "щеточными аппаратами электрических машин;\n" +
                "6. снятие, установка электросчетчиков, других приборов и средств измерений;\n" +
                "7. замена предохранителей, ремонт осветительной электропроводки и арматуры, замена\n" +
                "ламп и чистка светильников, расположенных на высоте не более 2,5 м;\n" +
                "8. другие работы, выполняемые на территории организации, в служебных и жилых\n" +
                "помещениях, складах, мастерских.\n" +
                "Приведенный перечень работ не является исчерпывающим и допускается его\n" +
                "дополнение по решению руководителя организации. В перечне работ также указываются\n" +
                "виды работ, выполняемые единолично.");
        q.add("Устанавливать заземления на токоведущие части необходимо непосредственно после\n" +
                "проверки отсутствия напряжения.\n" +
                "Переносное заземление сначала присоединяется к заземляющему устройству, а затем\n" +
                "проверяется отсутствие напряжения и устанавливается на токоведущие части.\n" +
                "На ВЛ при подвеске проводов на разных уровнях заземление устанавливается, начиная\n" +
                "с нижнего провода.\n" +
                "Переносное заземление присоединяется к заземляющей шине конструкции и\n" +
                "токоведущим частям в местах, очищенных от краски.\n" +
                "Снимать переносное заземление необходимо в обратной последовательности: сначала\n" +
                "снять его с токоведущих частей, а затем отсоединить от заземляющего устройства.");
        q.add("Тепловой удар - болезненное состояние, обусловленное общим перегреванием\n" +
                "организма и возникающее из-за воздействия внешних тепловых факторов. Тепловой удар\n" +
                "может начаться в результате пребывания в помещении с высокими температурой и\n" +
                "влажностью, при интенсивной физической работе в душных, плохо вентилируемых\n" +
                "помещениях. У пострадавшего наблюдаются чувство общей слабости, разбитости, головная\n" +
                "боль, головокружение, шум в ушах, сонливость, жажда, тошнота. При осмотре выявляется\n" +
                "покраснение кожных покровов. Пульс и дыхание учащены, температура повышена. В\n" +
                "тяжелых случаях пострадавший теряет сознание, иногда возникают судороги.\n" +
                "Первая доврачебная помощь: пострадавшего срочно вынести в прохладное место,\n" +
                "обеспечить доступ свежего воздуха, освободить от одежды, напоить холодной водой,\n" +
                "наложить холодный компресс на голову. В более тяжелых случаях показано обертывание\n" +
                "простыней, смоченной холодной водой, обливание прохладной водой, лед на голову и\n" +
                "паховые области; можно дать понюхать вату, смоченную нашатырным спиртом. При тяжелых\n" +
                "нарушениях сердечной и дыхательной деятельности приступить к выполнению\n" +
                "искусственного дыхания и непрямому массажу сердца: проводить их до восстановления\n" +
                "самостоятельного дыхания и сердцебиения или до прибытия медработника.\n" +
                "Солнечный удар - тяжелое болезненное состояние организма в результате перегрева\n" +
                "головы прямыми солнечными лучами. У пострадавшего отмечаются тошнота, рвота,\n" +
                "кровотечение из носа, возможно расстройство зрения, учащаются пульс и дыхание, в ряде \n" +
                "случаев отмечаются бессознательное состояние, остановка дыхания и сердечной\n" +
                "деятельности.\n" +
                "Первая доврачебная помощь: перенести пострадавшего в прохладное помещение или\n" +
                "в тень, снять с него одежду, положить холод на голову и в область сердца, дать обильное\n" +
                "солевое питье. При тяжелых формах приступить к проведению искусственного дыхания и\n" +
                "непрямого массажа сердца. Отправить, при необходимости, пострадавшего в лечебное\n" +
                "учреждение.");

        q.add("Работы, выполняемые в порядке текущей эксплуатации – небольшие по объему (не\n" +
                "более одной смены) ремонтные и другие работы по техническому обслуживанию,\n" +
                "выполняемые в электроустановках напряжением до 1000 В оперативным, оперативноремонтным персоналом на закрепленном оборудовании в соответствии с утвержденным\n" +
                "руководителем (главным инженером) организации перечнем.");
        q.add("В объем ежесменного технического обслуживания входят надзор за работой\n" +
                "электрооборудования, эксплуатационный уход, содержание оборудования в исправном\n" +
                "состоянии, включающие в себя:\n" +
                "1. соблюдение условий эксплуатации и режима работы оборудования в соответствии с\n" +
                "инструкцией завода-изготовителя;\n" +
                "2. загрузку оборудования в соответствии с его паспортными данными, недопущение\n" +
                "случаев перегрузки оборудования, за исключением оговоренных инструкциями по\n" +
                "эксплуатации;\n" +
                "3. ежесменную смазку эксплуатируемого оборудования, его наружную чистку, а также\n" +
                "уборку электропомещений;\n" +
                "4. строгое соблюдение порядка ввода в работу и остановки электрооборудования,\n" +
                "установленного инструкцией по эксплуатации завода-изготовителя, включения и\n" +
                "отключения электросетей;\n" +
                "5. немедленную остановку оборудования в случае появления неисправностей в его\n" +
                "работе, ведущих к выходу оборудования из строя, принятие мер по выявлению и\n" +
                "устранению этих неисправностей;\n" +
                "6. осмотр и выявление степени изношенности узлов и деталей и своевременную их\n" +
                "замену преимущественно на внешних крепежных деталях;\n" +
                "7. проверку нагрева контактных и трущихся поверхностей, проверку состояния масляных\n" +
                "и охлаждающих систем.");
        q.add("При работе по распоряжению допускается производителю работ с IV группой по\n" +
                "электробезопасности выполнять единолично монтаж, ремонт и эксплуатацию вторичных\n" +
                "цепей, измерительных приборов, устройств релейной защиты, автоматики, телемеханики и\n" +
                "связи, включая работы в приводах и агрегатных шкафах коммутационных аппаратов,\n" +
                "независимо от того, находятся они под напряжением или нет, в случае расположения этих\n" +
                "цепей и устройств в помещениях, где токоведущие части выше 1000 В отсутствуют или\n" +
                "полностью ограждены, или расположены на высоте, при которой не требуется ограждения");
        q.add("В электроустановках напряжением до 1000 В при работе под напряжением\n" +
                "необходимо:\n" +
                "1. оградить расположенные вблизи рабочего места другие токоведущие части,\n" +
                "находящиеся под напряжением, к которым возможно случайное прикосновение;\n" +
                "2. работать в диэлектрических галошах или стоя на изолирующей подставке либо на\n" +
                "диэлектрическом резиновом коврике;\n" +
                "3. применять инструмент с изолирующими рукоятками (у отверток, кроме того,\n" +
                "изолируется стержень), пользоваться диэлектрическими перчатками.\n" +
                "При работе под напряжением не допускается работать в одежде с короткими или\n" +
                "засученными рукавами, а также пользоваться ножом, напильниками, металлическими\n" +
                "линейками.");
        q.add("При пищевом отравлении дать выпить пострадавшему 5-6 стаканов теплой воды или\n" +
                "слабого раствора пищевой соды, чтобы промыть пострадавшему желудок и раздражая\n" +
                "пальцем корень языка, вызвать рвоту. Такую процедуру повторить несколько раз. После\n" +
                "промывания желудка дать пострадавшему растолченный активированный уголь (1 таблетка\n" +
                "на 10 кг веса), смекту и др. сорбенты, затем направить пострадавшего в лечебное\n" +
                "учреждение.\n" +
                "При отравлении кислотами или щелочами немедленно удалить слюну и слизь изо рта\n" +
                "пострадавшего. Навернув на чайную ложку кусок марли, платок или салфетку, протереть\n" +
                "полость рта. Если возникли признаки удушья - провести искусственное дыхание. Довольно\n" +
                "часто у пострадавших бывает рвота, иногда с примесью крови. Промывать самостоятельно\n" +
                "желудок в таких случаях категорически запрещается, так как это может усилить рвоту,\n" +
                "привести к попаданию кислот и щелочей в дыхательные пути. Пострадавшему можно дать\n" +
                "выпить 2-3 стакана воды, лучше со льдом. Нельзя пытаться «нейтрализовать» ядовитые\n" +
                "жидкости.\n" +
                "При отравлении газообразными химическими веществами (угарный газ, окислы азота,\n" +
                "аммиака, сернистый газ, и др.) пострадавшего в первую очередь нужно вывести на свежий\n" +
                "воздух, обеспечить ему удобное горизонтальное положение, освободить от стесняющей\n" +
                "одежды, дать понюхать ватку с нашатырным спиртом, если пострадавший в сознании ему \n" +
                "можно прополоскать горло и рот раствором соды. В случае отсутствия дыхания или его\n" +
                "значительного ослабления нужно начать проведение искусственного дыхания.\n");

        q.add("Подготовка рабочего места – выполнение до начала работ технических мероприятий\n" +
                "для предотвращения воздействия на работающего опасного производственного фактора на\n" +
                "рабочем месте.\n");
        q.add("Производство раскопок землеройными машинами на расстоянии ближе 1 м от кабеля,\n" +
                "а также использование отбойных молотков, ломов и кирок для рыхления грунта над\n" +
                "кабелями на глубину более 0,4 м при нормальной глубине прокладки кабелей не\n" +
                "допускаются.\n" +
                "Применение ударных и вибропогружных механизмов допускается на расстоянии не\n" +
                "менее 5 м от кабелей.\n" +
                "Для производства взрывных работ выдаются дополнительные технические условия.");
        q.add("Подготовка рабочего места и допуск бригады к работе проводится после получения\n" +
                "разрешения от оперативного персонала или уполномоченного на это работника. Порядок\n" +
                "допуска к выполнению работ в установках тепловой автоматики и измерений приведен в\n" +
                "главе 32 настоящих Правил.\n" +
                "Допускается передача по телефону, радио, с нарочным или через оперативный\n" +
                "персонал промежуточной подстанции разрешения персоналу, выполняющему подготовку\n" +
                "рабочего места и допуск бригады к работе.");
        q.add("При подготовке рабочего места отключаются:\n" +
                "1. токоведущие части, на которых будут производиться работы;\n" +
                "2. не ограждённые токоведущие части, к которым возможно случайное\n" +
                "приближение людей, механизмов и грузоподъемных машин на расстояние, менее\n" +
                "указанного в таблице 1 приложения 2 к настоящим Правилам;\n" +
                "3. при работе на отключенной ВЛ, когда не исключена возможность приближения\n" +
                "элементов этой ВЛ на расстояние, менее указанного в таблице 1 приложения 2 к\n" +
                "настоящим Правилам, к токоведущим частям других ВЛ, находящимся под\n" +
                "напряжением, последние отключаются.");
        q.add("Наиболее опасными являются нефтяные газы, в состав которых входит сероводород.\n" +
                "При больших концентрациях запах сероводорода ощущается слабо или совсем не\n" +
                "ощущается. Это свойство сероводорода может создать ложное впечатление об отсутствии\n" +
                "опасности.\n" +
                "При отравлениях сероводородом пострадавшего следует вынести на чистый воздух,\n" +
                "освободить от стесняющей и затрудняющей дыхание одежды, тепло укрыть, согреть, к ногам\n" +
                "положить грелки, напоить горячим крепким чаем или теплым молоком.\n" +
                "При наличии кислорода его необходимо подавать длительное время с небольшими\n" +
                "перерывами, если дыхание пораженного ослабевает – сделать искусственное дыхание.");

        q.add("Ремонтный персонал – персонал, обеспечивающий техническое обслуживание и\n" +
                "ремонт, монтаж, наладку и испытание электрооборудования.\n");
        q.add("Потребитель обеспечивает оперативное обслуживание электроустановок, которое\n" +
                "заключается:\n" +
                "1. в наблюдении за состоянием и режимом работы всего электрооборудования;\n" +
                "2. в периодических осмотрах электрооборудования;\n" +
                "3. в проведении в электроустановках на электрооборудовании не предусмотренных\n" +
                "планом небольших по объему работ согласно перечню работ, выполняемых в порядке\n" +
                "текущей эксплуатации и утверждаемых ответственным за электроустановки\n" +
                "потребителя;\n" +
                "4. в производстве оперативных переключений;\n" +
                "5. в подготовке схемы и рабочего места для ремонтных бригад, допуске их к работе,\n" +
                "контроль за ними во время работы и восстановлении схемы после окончания всех\n" +
                "работ.\n");
        q.add("Началу работ по наряду или распоряжению предшествует целевой инструктаж,\n" +
                "предусматривающий указания по безопасному выполнению конкретной работы в\n" +
                "последовательной цепи от выдавшего наряд (отдавшего распоряжение) до члена бригады\n" +
                "(исполнителя). Без проведения целевого инструктажа допуск к работе не разрешается.\n" +
                "Целевой инструктаж при работах по наряду проводят:\n" +
                "1. выдающий наряд – ответственному руководителю работ или, если ответственный\n" +
                "руководитель не назначается, производителю работ (наблюдающему);\n" +
                "2. допускающий – ответственному руководителю работ, производителю работ\n" +
                "(наблюдающему) и членам бригады;\n" +
                "3. ответственный руководитель работ – производителю работ (наблюдающему) и\n" +
                "членам бригады;\n" +
                "4. производитель работ (наблюдающий) – членам бригады.");
        q.add("Для подготовки рабочего места к работе, требующей снятия напряжения, выполняются\n" +
                "следующие мероприятия:\n" +
                "1. производятся необходимые отключения и принимаются меры во избежание\n" +
                "ошибочного или самопроизвольного включения отключенной коммутационной\n" +
                "аппаратуры;\n" +
                "2. вывешиваются запрещающие плакаты во избежание подачи напряжения на рабочее\n" +
                "место;\n" +
                "3. проверяется отсутствие напряжения на токоведущих частях;\n" +
                "4. налаживается заземление;\n" +
                "5. проводятся работы по ограждению рабочего места;\n" +
                "6. вывешиваются указательные знаки (плакаты) «ЗАЗЕМЛЕНО» по форме\n" +
                "согласно приложению 5 к настоящим Правилам.");
        q.add("Смотреть схему");

        q.add("Заземление – преднамеренное электрическое соединение какой-либо точки\n" +
                "электроустановки или оборудования с заземляющим устройством.\n" +
                "Защитное заземление – заземление частей электроустановки с целью обеспечения\n" +
                "электробезопасности.");
        q.add("На лицевой стороне щитов и сборок сети освещения имеются надписи (маркировка) с\n" +
                "указанием наименования, номера, соответствующего электрической схеме и диспетчерскому\n" +
                "наименованию.\n" +
                "На внутренней стороне (например, на дверцах) выполняется однолинейная схема с\n" +
                "указанием значений тока плавкой вставки или номинального тока автоматических\n" +
                "выключателей и наименований электроприемников, получающих через них питание.\n" +
                "Наименования электроприемников (светильников) излагаются так, чтобы работники\n" +
                "безошибочно производили включения и отключения электроприемников согласно схеме.");
        q.add("Ключи от электроустановок находятся на учете у оперативного персонала. В\n" +
                "электроустановках без местного оперативного персонала ключи находятся на учете у\n" +
                "административно-технического персонала.\n" +
                "Ключи пронумеровываются и хранятся в запираемом ящике. Один комплект ключей –\n" +
                "запасной.\n" +
                "Ключи выдаются под расписку:\n" +
                "1.работникам, имеющим право единоличного осмотра – от всех помещений;\n" +
                "2.при допуске – руководителю и производителю работ (наблюдающему) – от\n" +
                "помещений, в которых предстоит работать.\n" +
                "Ключи от камер в электроустановках напряжением выше 1000 В при допуске выдаются\n" +
                "допускающему из числа оперативного персонала.\n" +
                "Ключи подлежат возврату руководителем, производителем работ (наблюдающим)\n" +
                "ежедневно по окончании работ, при осмотре электроустановок – по завершении осмотра.\n" +
                "В электроустановках без местного оперативного персонала ключи возвращаются не\n" +
                "позднее следующего рабочего дня после осмотра или полного окончания работ.\n" +
                "Выдача и возврат ключей учитываются в специальном журнале произвольной формы\n" +
                "или в оперативном журнале.\n");
        q.add("При работе на электродвигателе допускается установка заземления на любом участке\n" +
                "КЛ, соединяющей электродвигатель с секцией РУ, щитом, сборкой.\n" +
                "В тех случаях, когда работы на электродвигателе рассчитаны на длительный срок, не\n" +
                "выполняются или прерваны на несколько дней, то отсоединенная от него КЛ заземляется\n" +
                "также со стороны электродвигателя.\n" +
                "В тех случаях, когда сечение жил кабеля не позволяет применять переносные\n" +
                "заземления, у электродвигателей напряжением до 1000 В допускается заземлять кабельную\n" +
                "линию медным проводником сечением не менее сечения жилы кабеля либо соединять\n" +
                "между собой жилы кабеля и изолировать их. Такое заземление или соединение жил кабеля\n" +
                "учитываются в оперативной документации наравне с переносным заземлением.\n");
        q.add("Шаговым напряжением называется напряжение между двумя точками цепи тока,\n" +
                "находящимися одна от другой на расстоянии шага, на которых одновременно стоит человек.\n" +
                "При попадании в зону действия шагового напряжения нельзя отрывать подошвы от\n" +
                "грунта, совершать широкие шаги или бежать. Зону шагового напряжения необходимо\n" +
                "покинуть исключительно передвигаясь «гусиным шагом», когда пятка ноги при следующем\n" +
                "шаге приставляется к носку другой ноги, или прыжками на одной ноге, однако следует\n" +
                "учитывать, что прыжки чреваты падением, которое повлечет за собой более серьезные\n" +
                "травмы. Также передвигаться в зоне \"шагового\" напряжения следует в диэлектрических ботах \n" +
                "или галошах - пятка шагающей ноги, не отрываясь от земли, приставляется к носку другой\n" +
                "ноги.");

        q.add("Комплектное распределительное устройство (далее – КРУ) – распределительное\n" +
                "устройство, состоящее из полностью или частично закрытых шкафов, или блоков со\n" +
                "встроенными в них аппаратами, устройствами защиты и автоматики, поставляемое в\n" +
                "собранном или полностью подготовленном для сборки виде");
        q.add("К работе с использованием переносного или передвижного электроприемника\n" +
                "допускаются работники, прошедшие инструктаж по охране труда и имеющие группу по\n" +
                "электробезопасности.\n" +
                "Переносные и передвижные электроприемники, вспомогательное оборудование к ним\n" +
                "подвергаются периодической проверке не реже одного раза в 6 месяцев. Результаты\n" +
                "проверки работники, отражают в журнале регистрации инвентарного учета, периодической\n" +
                "проверки и ремонта переносных и передвижных электроприемников, вспомогательного\n" +
                "оборудования к ним.\n" +
                "В объем периодической проверки переносных и передвижных электроприемников,\n" +
                "вспомогательного оборудования к ним входят:\n" +
                "1. внешний осмотр;\n" +
                "2. проверка работы на холостом ходу и под нагрузкой в течение не менее 5 минут;\n" +
                "3. измерение сопротивления изоляции.");
        q.add("Единоличный осмотр электроустановок выполняют оперативный персонал,\n" +
                "находящийся на дежурстве, а также административно-технический персонал с V группой по\n" +
                "электробезопасности. Право единоличного осмотра электроустановок административнотехническому персоналу предоставляется распоряжением по предприятию.\n" +
                "Работники, не имеющие разрешение единоличного осмотра электроустановки,\n" +
                "допускаются в помещение электроустановки в сопровождении работников, перечисленных в\n" +
                "пункте 19 настоящих Правил.\n" +
                "Контроль за безопасностью работников, допущенных к работе в электроустановках,\n" +
                "осуществляет сопровождающий работник.");
        q.add("Бланк наряда\nУказания по заполнению наряда:\n" +
                "1. Записи в наряде должны быть разборчивыми. Заполнение наряда карандашом и\n" +
                "исправления не допускаются.\n" +
                "2. Система нумерации нарядов устанавливается руководством предприятия.\n" +
                "3. При указании дат пишутся число, месяц и две последние цифры года, например:\n" +
                "10.08.12.\n" +
                "4. Кроме фамилии лиц, указываемых в наряде, записываются инициалы и группа по\n" +
                "электробезопасности.\n" +
                "5. В наряде указываются диспетчерские наименования (обозначения) электроустановок,\n" +
                "присоединений оборудования.\n" +
                "6. случае недостатка строк в таблицах или тексте наряда к нему прикладывается\n" +
                "дополнительный бланк наряда под тем же номером за подписью выдающего наряд\n" +
                "для продолжения записей. При этом в последних строках таблиц или в конце строки\n" +
                "основного бланка следует записать «См. дополнительный бланк».\n" +
                "Лицевая сторона наряда:\n" +
                "7. В строке «Подразделение» указывается структурное подразделение предприятия, в\n" +
                "котором предстоят работы.\n" +
                "8. Когда руководитель работ не назначается, в строке «Руководитель работ» указывается\n" +
                "«Не назначается».\n" +
                "9. В строке «Допускающему» указывается фамилия допускающего, если допуск проводит\n" +
                "оперативно-ремонтный персонал или производитель работ из числа ремонтного\n" +
                "персонала. Для электроустановок, где допускающим является дежурный, в строке\n" +
                "записывается «дежурному» без указания фамилии.\n" +
                "10. В строках «С членами бригады», кроме перечисления членов бригады, указывается, кто\n" +
                "из членов бригады является водителем, крановщиком, стропальщиком, а также тип\n" +
                "механизма, на котором он работает. Например: «Атыбеков А. К., гр.II, водитель\n" +
                "телевышки ТВ-26».\n" +
                "11. В строке «Категория работ» указывается полное наименование категории работ в\n" +
                "соответствии с терминами и их определениями.\n" +
                "12. В строках «Поручается» указываются: наименование электроустановки,\n" +
                "присоединения, участок ВЛ, номера опор, пролеты, цепь, фаза ВЛ, содержание работы.\n" +
                "13. В таблице 1 указываются:\n" +
                "- в графе 1 – наименования электроустановок, в которых необходимо провести\n" +
                "операции с коммутационными аппаратами и установить заземления;\n" +
                "- в графе 2 – места, где производятся отключения коммутационных аппаратов и\n" +
                "устанавливаются заземления.\n" +
                "При заполнении графы 2 должны соблюдаться следующие правила:\n" +
                "- для электроустановок станций и подстанций указываются наименования\n" +
                "(обозначения) коммутационных аппаратов, отключаемых для обеспечения\n" +
                "видимого разрыва, а также места установки заземлений;\n" +
                "- для ВЛ и КЛ, отключаемых персоналом, их не обслуживающим, в строке,\n" +
                "соответствующей наименованию электроустановки, в гр.1, записывается\n" +
                "наименование (обозначение) линии с указанием о необходимости ее\n" +
                "заземления в РУ и на рабочем месте;\n" +
                "- для ВЛ и КЛ, отключаемых оперативно-ремонтным персоналом, указываются\n" +
                "наименования (обозначения) коммутационных аппаратов в РУ и на самой ВЛ, \n" +
                "отключаемых для обеспечения видимого разрыва, а также места установки\n" +
                "заземлений (в РУ и на рабочем месте);\n" +
                "- для ВЛ и КЛ, отключаемых как персоналом, их не обслуживающим, так и\n" +
                "оперативно-ремонтным персоналом, записи проводятся для каждого из них в\n" +
                "соответствии с вышеизложенными правилами.\n" +
                "При работах, не требующих подготовки рабочего места, в графах таблицы 1 делается\n" +
                "запись «Не требуется».\n" +
                "14. В строках «Отдельные указания» записываются:\n" +
                "- дополнительные меры, обеспечивающие безопасность работающих (установка\n" +
                "дополнительных заземлений и ограждений, проверка воздуха на наличие\n" +
                "опасного газа, меры пожарной безопасности и т.п.), а также разрешение\n" +
                "выполнить эти меры самой бригаде;\n" +
                "- в случае оформления наряда наблюдающему - работник, возглавляющий\n" +
                "бригаду;\n" +
                "- разрешение руководителю или производителю работ (наблюдающему)\n" +
                "выполнять перевод бригады на другое рабочее место;\n" +
                "- разрешение включить электроустановку или часть ее без распоряжения\n" +
                "дежурного;\n" +
                "- разрешение на временное снятие заземлений; другие записи, связанные с\n" +
                "выполняемой работой.\n" +
                "15. Таблица 2 заполняется при получении разрешения на первичный допуск.\n" +
                "В графе 1 указываются фамилия и должность лица, от которого допускающий получил\n" +
                "это разрешение. При выдаче разрешения лично в графе 1 расписывается лицо,\n" +
                "выдавшее разрешение, с указанием своей должности.\n" +
                "Оборотная сторона наряда:\n" +
                "16. При работах в электроустановках электростанций и подстанций в строках «Рабочие\n" +
                "места подготовлены. Под напряжением остались» допускающий указывает оставшиеся\n" +
                "под напряжением токоведущие части ремонтируемого присоединения, а также\n" +
                "токоведущие части соседних присоединений, ближайшие к рабочему месту.\n" +
                "При работах на ВЛ и КЛ в этих строках указываются пересекающие, сближающиеся в\n" +
                "охранной зоне ремонтируемой линии другие ВЛ и КЛ.\n" +
                "При необходимости допускающий указывает и другие токоведущие части.\n" +
                "Допускающий и руководитель работ (производитель работ или наблюдающий, если\n" +
                "руководитель не назначен) расписываются под строками «Рабочие места\n" +
                "подготовлены. Под напряжением остались» только при первичном допуске, после\n" +
                "приемки рабочего места.\n" +
                "17. В таблице 3 оформляются ежедневный допуск к работе и ее окончание, а также\n" +
                "перевод бригады на другое рабочее место.\n" +
                "Если руководитель (производитель) работ совмещает обязанности допускающего, он\n" +
                "при допуске расписывается в графах 3 и 4.\n" +
                "18. Изменения в составе бригады отражаются в таблице 4 и удостоверяются подписью\n" +
                "выдающего наряд в графе 4 таблицы. При передаче разрешения на изменение состава\n" +
                "бригады по телефону, радио или с нарочным руководитель (производитель) работ в\n" +
                "графе 4 за своей подписью записывает фамилию лица, давшего разрешение.\n" +
                "При вводе в бригаду или выводе из нее водителя автомобиля или машиниста \n" +
                "механизма и крановщика указывается также тип закрепленного за ним автомобиля,\n" +
                "механизма.\n" +
                "19. Если бригада заземлений не устанавливала, то слова «заземления, установленные\n" +
                "бригадой, сняты» из текста вычеркиваются. Остальные строки в бланке наряда\n" +
                "заполняются в соответствии с их наименованием и подстрочным текстом. В\n" +
                "неиспользуемых строках делаются прочерки.");
        q.add("Внеплановый инструктаж проводят в случаях:\n" +
                "1) при введении в действие новых или переработанных норм безопасности, правил,\n" +
                "инструкций по безопасности и охране труда;\n" +
                "2) при изменении технологического процесса, замене или модернизации оборудования,\n" +
                "приспособлений и инструмента, исходного сырья, материалов и других факторов,\n" +
                "влияющих на безопасность труда;\n" +
                "3) при нарушении работниками требований безопасности труда, которые могут привести\n" +
                "или привели к травме, аварии, взрыву или пожару, отравлению;\n" +
                "4) по требованию контролирующих надзорных органов.\n");

        q.add("Категория работ – работы, указываемые в соответствующей графе наряда-допуска,\n" +
                "подразделяются на работы со снятием напряжения, без снятия напряжения, без снятия\n" +
                "напряжения на потенциале токоведущей части.");
        q.add("Для питания переносных (ручных) светильников в помещениях с повышенной\n" +
                "опасностью и особо опасных помещениях применяется напряжение не выше 42 В, а при\n" +
                "повышенной опасности поражения электрическим током и в наружных установках – не выше\n" +
                "12 В.\n" +
                "Вилки приборов на напряжение 12 – 42 В не входят в розетки на напряжение 127 и 220\n" +
                "В. На всех штепсельных розетках имеются надписи с указанием номинального напряжения.\n" +
                "Использование автотрансформаторов для питания светильников сети 12 – 42 В не\n" +
                "допускается. Питание светильников до 42 В производится от безопасных разделяющих\n" +
                "трансформаторов или от автономных источников тока.\n" +
                "Применение для переносного освещения люминесцентных ламп и дуговых ртутных\n" +
                "ламп, не укрепленных на жестких опорах, не допускается.");
        q.add("Организацией техники безопасности при эксплуатации электроустановок\n" +
                "потребителей являются:\n" +
                "1. выдача наряда или распоряжения на производство работ;\n" +
                "2. организация работ, выполняемых в порядке текущей эксплуатации, согласно их\n" +
                "перечню;\n" +
                "3. выдача разрешения на допуск на рабочее место;\n" +
                "4. допуск на рабочее место;\n" +
                "5. надзор при выполнении работ;\n" +
                "6. перевод на другое рабочее место;\n" +
                "7. оформление перерывов в работе, окончание работы.");
        q.add("Измерения мегомметром в процессе эксплуатации выполняют обученные работники из\n" +
                "числа электротехнического персонала. В электроустановках напряжением выше 1000 В\n" +
                "измерения проводятся по наряду, в электроустановках напряжением до 1000 В – по\n" +
                "распоряжению.\n" +
                "В тех случаях, когда измерения мегомметром входят в содержание работ, оговаривать\n" +
                "эти измерения в наряде или распоряжении не требуется.\n" +
                "Измерение сопротивления изоляции мегомметром может выполнять работник с III\n" +
                "группой по электробезопасности.\n" +
                "Измерение сопротивления изоляции мегомметром выполняется на отключенных\n" +
                "токоведущих частях, с которых снимается заряд путем предварительного их заземления.\n" +
                "Заземление с токоведущих частей снимается после подключения мегомметра.\n" +
                "При измерении мегомметром сопротивления изоляции токоведущих частей\n" +
                "соединительные провода присоединяются к ним с помощью изолирующих держателей\n" +
                "(штанг). В электроустановках напряжением выше 1000 В, кроме того, используются\n" +
                "диэлектрические перчатки.\n");
        q.add("Основные электрозащитные средства - это средства защиты, изоляция которых\n" +
                "длительно выдерживает рабочее напряжение электроустановок, и которые позволяют\n" +
                "прикасаться к токоведущим частям, находящимся под напряжением.\n" +
                "Дополнительные электрозащитные средства - это средства защиты, которые сами по\n" +
                "себе не могут при данном напряжении обеспечить защиту от поражения током, а\n" +
                "применяются совместно с основными электрозащитными средствами.");


        for (int i = 0; i < 75; i++) {
            double numberTicket =  Math.ceil(i/5);
            createQuestion(String.valueOf((int) numberTicket), t.get(i), "0", q.get(i));
        }
    }
}

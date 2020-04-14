package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        cursor.close();

        dbHelper.close();*/
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
            Utils.numberQuestion.add(String.valueOf(i + 1));
            Utils.questionDuplicate.add(String.valueOf(i + 1));
        }
    }

    public void setTicketValueToList() {
        for (int i = 0; i < 15; i++)
            Utils.numberTicket.add(String.valueOf(i+1));
    }
}

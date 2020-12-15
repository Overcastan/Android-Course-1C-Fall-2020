package com.github.overcastan.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Stream;

public class DataRepository {
    private static final Map<Long, Data> DATA_LIST = new HashMap<>();

    static long pl15 = R.mipmap.pl15sqr;
    static long vector = R.mipmap.kvectorsqr;
    static long fal = R.mipmap.fnfalsqr;
    static long rdb = R.mipmap.ktrdbsqr;
    static long p226 = R.mipmap.ss226sqr;
    static long mdr = R.mipmap.dtmdrsqr;
    static long hk416 = R.mipmap.hk416sqr;
    static long mp5 = R.mipmap.mp5sqr;
    static long sr3 = R.mipmap.sr3msqr;

//    @RequiresApi(api = Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void initialize(final Context context) {
        List<Long> imgIDs = List.of(pl15, vector, fal, rdb, p226, mdr, hk416, mp5, sr3);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("info.txt")))) {
            String info = reader.readLine();
            long id = 0;
            while (!TextUtils.isEmpty(info)) {
                DATA_LIST.put(id, new Data(id, info));
                ++id;
                info = reader.readLine();
            }
        } catch (IOException e) {
            // Do nothing
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("dates.txt")))) {
            String date = reader.readLine();
            long id = 0;
            while (!TextUtils.isEmpty(date)) {
                Objects.requireNonNull(DATA_LIST.get(id)).setDate(date);
                ++id;
                date = reader.readLine();
            }
        } catch (IOException e) {
            // Do nothing
        }

        for (long i = 0; i < DATA_LIST.size(); ++i) {
            DATA_LIST.get(i).setImageID(Math.toIntExact(imgIDs.get((int) i)));
        }
    }

    public static List<Data> getDataList() {
        return new ArrayList<>(DATA_LIST.values());
    }

    public static Data getDataById(final long id) {
        return DATA_LIST.get(id);
    }
}

package com.amjad.school.ui.fragment;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.school.R;
import com.amjad.school.adapter.CategoryAdapter;
import com.amjad.school.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.Locale;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ArrayList<Category> categoryArrayList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = root.findViewById(R.id.imageView_category);

            categoryArrayList = new ArrayList<>();
            categoryArrayList.add(new Category(0, R.drawable.classroom, "الفصول الدراسية", "ابتدائي اعدادي ثانوي"));
            categoryArrayList.add(new Category(1, R.drawable.recoedstudent, "سجل الطلاب", "إضافة طلاب "));
            categoryArrayList.add(new Category(2, R.drawable.brecenceandabscence, "الحضور والغياب", "متابعة يومية"));
            categoryArrayList.add(new Category(3, R.drawable.studentactivity, "نشاط الطلاب", "متابعة الانشطة المدرسية"));
            categoryArrayList.add(new Category(4, R.drawable.exam, "الاختبارات", "درجات الاختبارات"));
            categoryArrayList.add(new Category(5, R.drawable.report, "تقرير", "شهادات  وانجازات طالب"));
            categoryArrayList.add(new Category(6, R.drawable.monyfolder, "الملف المالى", "حساب طالب"));
            categoryArrayList.add(new Category(7, R.drawable.logout, "تسجيل خروج", ""));
            categoryAdapter = new CategoryAdapter(getContext(), categoryArrayList);
            recyclerView.setLayoutManager(new GridLayoutManager(getcontex,2));

                recyclerView.setAdapter(categoryAdapter);
                recyclerView.setHasFixedSize(true);






        return root;

}
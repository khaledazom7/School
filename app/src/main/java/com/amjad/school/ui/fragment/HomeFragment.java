package com.amjad.school.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.school.R;
import com.amjad.school.adapter.CategoryAdapter;
import com.amjad.school.model.Category;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private ArrayList<Category> categoryFragmentArrayList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.imageView_category);

        categoryFragmentArrayList = new ArrayList<>();
        categoryFragmentArrayList.add(new Category(0, R.drawable.classroom, "الفصول الدراسية", "ابتدائي اعدادي ثانوي"));
        categoryFragmentArrayList.add(new Category(1, R.drawable.recoedstudent, "سجل الطلاب", "إضافة طلاب "));
        categoryFragmentArrayList.add(new Category(2, R.drawable.brecenceandabscence, "الحضور والغياب", "متابعة يومية"));
        categoryFragmentArrayList.add(new Category(3, R.drawable.studentactivity, "نشاط الطلاب", "متابعة الانشطة المدرسية"));
        categoryFragmentArrayList.add(new Category(4, R.drawable.exam, "الاختبارات", "درجات الاختبارات"));
        categoryFragmentArrayList.add(new Category(5, R.drawable.report, "تقرير", "شهادات  وانجازات طالب"));
        categoryFragmentArrayList.add(new Category(6, R.drawable.monyfolder, "الملف المالى", "حساب طالب"));
        categoryFragmentArrayList.add(new Category(7, R.drawable.logout, "تسجيل خروج", ""));
        categoryAdapter = new CategoryAdapter(getContext(), categoryFragmentArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setHasFixedSize(true);


        return root;

    }
}
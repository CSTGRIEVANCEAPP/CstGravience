package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cstgravience.fragments.Hostel;
import com.example.cstgravience.fragments.Mess;
import com.example.cstgravience.fragments.Personal;
import com.example.cstgravience.fragments.academic;


public class myadapter extends FragmentStateAdapter {

    public myadapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new academic();
            case 1:
                return new Hostel();
            case 2:
                return new Mess();
                case 3:
                return new Personal();
            default:
                return new academic();
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}

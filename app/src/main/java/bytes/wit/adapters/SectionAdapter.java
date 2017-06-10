package bytes.wit.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.models.Section;
import bytes.wit.shobdho.HomeActivity;
import bytes.wit.shobdho.R;
import bytes.wit.shobdho.databinding.ItemSelectionListBinding;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {

    private ArrayList<Section> mSections = new ArrayList<>();
    private HomeActivity.OnSectionItemClickListener mOnSectionItemClickListener;

    public SectionAdapter(HomeActivity.OnSectionItemClickListener onSectionItemClickListener) {
        mOnSectionItemClickListener = onSectionItemClickListener;
    }

    @Override
    public SectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSelectionListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_selection_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(SectionAdapter.ViewHolder holder, int position) {
        holder.bindTo();
    }

    @Override
    public int getItemCount() {
        return mSections.size();
    }

    public void setItems(List<Section> sections) {
        //mSections.clear();
        mSections.addAll(sections);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemSelectionListBinding binding;
        public ViewHolder(ItemSelectionListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo() {
            binding.setSection(mSections.get(getAdapterPosition()));
            binding.setEvent(mOnSectionItemClickListener);
        }
    }
}

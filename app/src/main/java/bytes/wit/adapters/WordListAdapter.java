package bytes.wit.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.factory.models.Word;
import bytes.wit.shobdho.R;
import bytes.wit.shobdho.databinding.ItemSelectionListBinding;
import bytes.wit.shobdho.databinding.ItemWordListBinding;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private List<Word> mWords = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWordListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_word_list, parent, false);
        return new WordListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTo();
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public void setItems(List<Word> sections) {
        mWords.clear();
        mWords.addAll(sections);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemWordListBinding binding;
        public ViewHolder(ItemWordListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindTo() {
            binding.tvWord.setText(mWords.get(getAdapterPosition()).getWord());
        }
    }
}

package bytes.wit.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bytes.wit.diffutills.WordListDiffUtil;
import bytes.wit.factory.models.Word;
import bytes.wit.shobdho.R;
import bytes.wit.shobdho.WordListActivity;
import bytes.wit.shobdho.databinding.ItemSelectionListBinding;
import bytes.wit.shobdho.databinding.ItemWordListBinding;

/**
 * Created by Md. Sifat-Ul Haque on 6/2/2017.
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private List<Word> mWords = new ArrayList<>();
    private WordListActivity.OnItemClickListener mOnItemClickListener;

    public WordListAdapter(WordListActivity.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWordListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_word_list, parent, false);
        return new WordListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTo(mWords.get(position));
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public void setItems(List<Word> sections) {

        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new WordListDiffUtil(mWords, sections));
        mWords.clear();
        mWords.addAll(sections);
        result.dispatchUpdatesTo(listUpdateCallback);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemWordListBinding binding;
        public ViewHolder(ItemWordListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(Word word) {
            binding.setEvent(mOnItemClickListener);
            binding.setWord(word);
        }
    }

    private ListUpdateCallback listUpdateCallback = new ListUpdateCallback() {
        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count, Object payload) {
            notifyItemRangeChanged(position, count);
        }
    };
}

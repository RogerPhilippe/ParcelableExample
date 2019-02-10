package br.com.philippesis.parcelableexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class Pessoa implements Parcelable {

    private String mNome;
    private int mDataNascimento;
    private int mIdade;

    public Pessoa(String mNome, int mDataNascimento) {
        this.mNome = mNome;
        this.mDataNascimento = mDataNascimento;
    }

    public Pessoa(Parcel in) {
        mNome = in.readString();
        mDataNascimento = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mNome);
        dest.writeLong(mDataNascimento);

    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel source) {
            return new Pessoa(source);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public void calculaIdade() {

        mIdade = Calendar.getInstance().get(Calendar.YEAR) - mDataNascimento;

    }

    @Override
    public String toString() {
        return mNome + " idade " + mIdade;
    }

}

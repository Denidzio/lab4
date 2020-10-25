package com.company;/* Created by IntelliJ IDEA.
lab 4.CustomArray 
* @Author: Den1k
* @DateTime: 25.10.2020|15:26 
* @Version CustomArray: 1.0
*/

import java.util.Arrays;

public class CustomArray {

    private String[] keys;
    private int[] values;

    public CustomArray(){

        keys = new String[0];
        values = new int[0];

    }

    public CustomArray(String[] keys, int[] values){

        int length = keys.length;

        this.keys = new String[keys.length];
        this.values = new int[values.length];

        for(int i = 0; i < keys.length; i++){

            this.keys[i] = keys[i];
            this.values[i] = values[i];

        }

    }

    public boolean isKeyExists(String key){

        for(String str : this.keys)
            if(str.equals(key))
                return true;

        return false;
    }

    public void add(String key, int value){

        if(this.isKeyExists(key))
            throw new IllegalArgumentException("The key " + key + " already exists!");

        String[] tempKeys = new String[this.keys.length + 1];
        int[] tempValues = new int[this.values.length + 1];

        for (int i = 0; i < this.keys.length; i++)
            tempKeys[i] = this.keys[i];

        for (int i = 0; i < this.values.length; i++)
            tempValues[i] = this.values[i];

        tempKeys[tempKeys.length - 1] = key;
        tempValues[tempValues.length - 1] = value;

        this.keys = tempKeys;
        this.values = tempValues;

    }

    public void set(String key, int value){

        int position = this.getElementIndex(key);

        switch(position){
            case -1:
                throw new IllegalArgumentException("The key " + key + " doesn't exist!");
            default:
                this.values[position] = value;
        }

    }

    public int get(String key){

        int position = this.getElementIndex(key);

        switch(position){
            case -1:
                throw new IllegalArgumentException("The key " + key + " doesn't exist!");
            default:
                return this.values[position];
        }

    }

    public int getElementIndex(String key){

        int position = -1;

        for (int i = 0; i < this.keys.length; i++)
            if(this.keys[i].equals(key)){
                position = i;
                break;
            }

        return position;

    }

    public CustomArray clone(){

        CustomArray cloneArr = new CustomArray();

        for(int i = 0; i < this.keys.length; i++)
            cloneArr.add(this.keys[i], this.values[i]);

        return cloneArr;

    }

    // mode 0: decrease;
    // mode 1: increase

    public CustomArray sort(byte mode){

        String[] sortKeys = new String[this.keys.length];
        int[] sortValues = new int[this.values.length];

        for(int i = 0; i < this.keys.length; i++) {

            sortKeys[i] = this.keys[i];
            sortValues[i] = this.values[i];

        }

        String tempWord;
        int tempValue;

        for (int i = 0; i < sortKeys.length; i++) {

            switch (mode) {

                case 0:

                    int max = i;

                    for (int j = i + 1; j < sortKeys.length; j++)
                        if (sortValues[j] > sortValues[max])
                            max = j;

                    tempWord = sortKeys[i];
                    sortKeys[i] = sortKeys[max];
                    sortKeys[max] = tempWord;

                    tempValue = sortValues[i];
                    sortValues[i] = sortValues[max];
                    sortValues[max] = tempValue;

                    break;

                case 1:

                    int min = i;

                    for (int j = i + 1; j < sortKeys.length; j++)
                        if (sortValues[j] < sortValues[min])
                            min = j;

                    tempWord = sortKeys[i];
                    sortKeys[i] = sortKeys[min];
                    sortKeys[min] = tempWord;

                    tempValue = sortValues[i];
                    sortValues[i] = sortValues[min];
                    sortValues[min] = tempValue;

                    break;

            }

        }


        return new CustomArray(sortKeys, sortValues);

    }

    @Override
    public String toString() {

        String str = "";

        for(int i = 0; i < this.keys.length; i++)
            str += (i < this.keys.length - 1) ?
                    "[" + this.keys[i] + ", " + this.values[i] + "], " :
                    "[" + this.keys[i] + ", " + this.values[i] + "]";

        return "{" + str + "}";
    }
}
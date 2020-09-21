package com.company;

public class Main {

    public static boolean arrContainStrElem(String elem, String[] arr){

        for(int i = 0; i < arr.length; i++)
            if(arr[i].equals(elem))
                return true;

        return false;

    }

    public static String[] strArrPushItem(String elem, String[] arr){

        String[] new_arr;
        new_arr = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            new_arr[i] = arr[i];

        new_arr[new_arr.length - 1] = elem;

        return new_arr;

    }

    public static int[] intArrPushItem(int elem, int[] arr){

        int[] new_arr;
        new_arr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            new_arr[i] = arr[i];

        new_arr[new_arr.length - 1] = elem;

        return new_arr;

    }

    public static void main(String[] args) {

        String potter = "Harry woke early the next morning. Although he could tell it was daylight, he kept his eyes shut tight." +
                "It was a dream, he told himself firmly. I dreamed a giant called Hagrid came to tell me I was going to a school for wizards. When I open my eyes I'll be at home in my cupboard." +
                "There was suddenly a loud tapping noise. " +
                "And there's Aunt Petunia knocking on the door, Harry thought, his heart sinking. But he still didn't open his eyes. It had been such a good dream." +
                "Tap. Tap. Tap. " +
                "All right, Harry mumbled, I'm getting up." +
                "He sat up and Hagrid's heavy coat fell off him. The hut was full of sunlight, the storm was over, Hagrid himself was asleep on the collapsed sofa, and there was an owl rapping its claw on the window, a newspaper held in its beak." +
                "Harry scrambled to his feet, so happy he felt as though a large balloon was swelling inside him. He went straight to the window and jerked it open. The owl swooped in and dropped the newspaper on top of Hagrid, who didn't wake up. The owl then fluttered onto the floor and began to attack Hagrid's coat." +
                "Don't do that." +
                "Harry tried to wave the owl out of the way, but it snapped its beak fiercely at him and carried on savaging the coat." +
                "Hagrid! said Harry loudly. There's an owl Pay him, Hagrid grunted into the sofa. " +
                "What?" +
                "He wants payin' fer deliverin' the paper. Look in the pockets." +
                "Hagrid's coat seemed to be made of nothing but pockets -- bunches of keys, slug pellets, balls of string, peppermint humbugs, teabags..." +
                "Give him five Knuts, said Hagrid sleepily. " +
                "Knuts?" +
                "The little bronze ones. ";

        potter = potter.toLowerCase().replaceAll("[[(){},.:;!?<>%\n-]]", "");

        String[] potter_words = potter.split(" ");
        String[] uniq_potter_words = {};

        int[] count_repeat_potter_words = {};

        int counter_uniq_words = 0;

        for(int i = 0; i < potter_words.length; i++)

            if(!arrContainStrElem(potter_words[i], uniq_potter_words)) {

                counter_uniq_words += 1;
                uniq_potter_words = strArrPushItem(potter_words[i], uniq_potter_words);

                int counter_repeat_uniq_word = 0;

                for (int j = 0; j < potter_words.length; j++)

                    if (potter_words[i].equals(potter_words[j])) {

                        counter_repeat_uniq_word++;

                        if (counter_repeat_uniq_word == 1)
                            count_repeat_potter_words = intArrPushItem(counter_repeat_uniq_word, count_repeat_potter_words);
                        else
                            count_repeat_potter_words[counter_uniq_words - 1] = counter_repeat_uniq_word;

                    }

            }

        for (int i = 0; i < count_repeat_potter_words.length; i++) {

            int max = i;

            for (int j = i + 1; j < count_repeat_potter_words.length; j++)
                if(count_repeat_potter_words[j] > count_repeat_potter_words[max])
                    max = j;

            String tmp_word = uniq_potter_words[i];
            uniq_potter_words[i] = uniq_potter_words[max];
            uniq_potter_words[max] = tmp_word;

            int tmp_index_item = count_repeat_potter_words[i];
            count_repeat_potter_words[i] = count_repeat_potter_words[max];
            count_repeat_potter_words[max] = tmp_index_item;

        }

        for (int i = 0; i < uniq_potter_words.length; i++) {
            System.out.println(uniq_potter_words[i]);
        }

    }
}

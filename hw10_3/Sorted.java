package hw10_3;

public class Sorted {

        private final String word;
        private final int counter;

        public Sorted(String word, int counter) {
            this.word = word;
            this.counter = counter;

        }

        @Override
        public String toString() {
            return word + " " + counter;
        }
        public int getWordCount() {
            return counter;
        }
    }


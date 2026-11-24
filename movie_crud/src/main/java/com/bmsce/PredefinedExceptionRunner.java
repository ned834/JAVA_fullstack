package com.bmsce;

public class PredefinedExceptionRunner {

    public static void main(String[] args) {

        // 1. ArithmeticException

        try {

            int totalMovies = 100;
            int theatres = 0;

            int result = totalMovies / theatres;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Cannot divide movies by zero theatres"
            );
        }

        // 2. NumberFormatException

        try {

            String rating = "Excellent";

            double movieRating =
                    Double.parseDouble(rating);

            System.out.println(movieRating);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid movie rating format"
            );
        }

        // 3. ArrayIndexOutOfBoundsException

        try {

            String[] movies = {
                    "Interstellar",
                    "Inception",
                    "Avatar"
            };

            System.out.println(movies[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Invalid movie array index"
            );
        }

        // 4. NullPointerException

        try {

            String movieName = null;

            System.out.println(movieName.length());

        } catch (NullPointerException e) {

            System.out.println(
                    "Movie name cannot be null"
            );
        }

        finally {

            System.out.println(
                    "Exception handling demonstration completed"
            );
        }
    }
}


package com.example.restfulwebservices.service;

public class RectanglesUnion {

    private static int[] cantC;
    public static int calculateSpace(int[][] rectangles) {
        getCantC(rectangles.length);
        int result = getResult(rectangles);
        if (rectangles.length > 0) {
            rectangles = searchUnion(rectangles);
        }
        return result - getResult(rectangles);
    }

    private static int getResult(int[][] rectangles) {
        int result = 0;
        for (int[] rectangle : rectangles) {
            if (((rectangle[3] - rectangle[1]) >= 0 &&
                    (rectangle[2] - rectangle[0]) >= 0)) {
                result += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            }
        }
        return result;
    }

    private static void getCantC(int r){
        cantC = new int[r];
        if(r>1){
            cantC[1]=1;
            for (int i = 2; i<r; i++){
                cantC[i]+=cantC[i-1]+i;
            }
        }else {
            cantC[0]=1;
        }
    }

    private static int[][] searchUnion(int[][] rectangles) {
        int[][] result = new int[cantC[rectangles.length-1]][rectangles[0].length];
        int c = 0;
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                result[c][0] = (rectangles[i][0] > rectangles[j][0]) ?
                        rectangles[i][0] : rectangles[j][0];
                result[c][1] = (rectangles[i][1] > rectangles[j][1]) ?
                        rectangles[i][1] : rectangles[j][1];
                result[c][2] = (rectangles[i][2] < rectangles[j][2]) ?
                        rectangles[i][2] : rectangles[j][2];
                result[c][3] = (rectangles[i][3] < rectangles[j][3]) ?
                        rectangles[i][3] : rectangles[j][3];
                c++;
            }
        }
        return result;
    }
}

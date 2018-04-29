package com.b3.service;

import java.lang.reflect.Array;

public class AnalysisAbility {
	public float analysisAbility(float a1,float a2,float a3,float a4,float a5) {
		float[] array = new float[5];
		//float[] array = null;
		array[0]=a1;
		array[1]=a2;
		array[2]=a3;
		array[3]=a4;
		array[4]=a5;
		
		float t = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array[0];
	}
}

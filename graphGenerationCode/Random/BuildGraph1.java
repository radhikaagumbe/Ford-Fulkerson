package graphGenerationCode.Random;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import graphCode.KeyboardReader;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BuildGraph1 {
	public static void main(String[] args) 
	{
		//Scanner s = new Scanner(System.in);
		System.out.println("enter the filename of new graph\n");
		 String f = KeyboardReader.readString();
		System.out.println("enter the path where it is to be saved\n");
		String p = KeyboardReader.readString();
		System.out.println("enter v - the number of vertices in the graph\n");
		int v=KeyboardReader.readInt();
		
			System.out.println("enter dense value\n");
			int d=KeyboardReader.readInt();
			System.out.println("min - the lower bound on edge capacities\n");
			int min=KeyboardReader.readInt();

			System.out.println("max - the upper bound on edge capacities");
			int max=KeyboardReader.readInt();
			BuildGraph1 ob = new BuildGraph1();
			  ob.buildGraph1(f,p,v,d,max,min);

			
		
	}







private static String GetString() {
		// TODO Auto-generated method stub
		return null;
	}





public void buildGraph1(String fileName, String directory, int vertices, int dense, int maxCapacity, int minCapacity) {
	Random random = new Random();
	try {
		String dirName = directory;//
		if (dirName.equals("")) {
			dirName = ".";
		}

		File outputfile = new File(dirName, fileName);
		int[][] Graph = new int[vertices][vertices];
		int n, m;

		for (n = 0; n < vertices; n++)
			for (m = n + 1; m < vertices; m++) {
				System.out.println("min capacity is:"+minCapacity);
				System.out.println("max capacity is:"+maxCapacity);
				
				int randomInt = (random.nextInt((maxCapacity - minCapacity + 1)) + minCapacity);
				

				int k = (int) (1000.0 * Math.random() / 10.0);
				int b = (k < dense) ? 1 : 0;
				if (b == 0) {
					Graph[n][m] = Graph[m][n] = b;
				} else {
					Graph[n][m] = Graph[m][n] = randomInt;
				}
			}

		PrintWriter output = new PrintWriter(new FileWriter(outputfile));

		for (int x = 0; x < Graph.length; x++) {
			if (x == 0) {
				for (int y = 0; y < Graph[x].length; y++) {
					String value = String.valueOf(Graph[x][y]);
					if (y != 0) {
						if (value.equals("0") == false) {
							output.print("s " + String.valueOf(y) + " " + value + "\n");
						}
					}
				}
			} else {
				if (x == Graph.length - 1) {
					for (int y = 0; y < Graph[x].length; y++) {
						String value = String.valueOf(Graph[x][y]);
						if (y != 0) {
							if (value.equals("0") == false) {
								output.print(String.valueOf(y) + " t " + value + "\n");
							}
						}
					}
				} else {
					for (int y = 0; y < Graph[x].length; y++) {
						String value = String.valueOf(Graph[x][y]);
						if (y != 0) {
							if (value.equals("0") == false) {
								output.print(x + " " + String.valueOf(y) + " " + value + "\n");
							}
						}
					}
				}
			}

		}

		output.close();
	} catch (IOException e) {
		System.err.println("Error opening file" + e);
		return;
	}
	System.out.print("\nDone");
}
}

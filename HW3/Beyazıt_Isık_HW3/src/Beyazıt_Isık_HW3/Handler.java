/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beyazıt_Isık_HW3;
import Beyazıt_Isık_HW3.MatrixFinder;
import javaapplication12.ReadandParse;
import Beyazıt_Isık_HW3.CustomLinkedList;
/**
 *
 * @author Beyazit
 */
public class Handler implements HW3_Interface {
    private CustomLinkedList linkedlist;
    public int [][] matrix; // Keeps the elements of matrix in two dimensional array
    public MatrixFinder finder;
    private String matrix_file_string;
    //private ReadandParse reader;
    public Handler(){ //Constructor
       this.matrix= new int[11][14];
       this.finder = new MatrixFinder(this.matrix);
       this.linkedlist =new CustomLinkedList();
       this.matrix_file_string="";
    }

    public void ReadShapeFile(String path)
    {
        ReadandParse reader = new ReadandParse(path);
        this.matrix=reader.get_matrix();
        //reader.intprintMatrix(); for debug
    }
    public void OutputShapes() {
        linkedlist=(CustomLinkedList) this.finder.ShapeFind(this.matrix);
        //char[][] deneme;
        //deneme = this.finder.temp_matrix;
        //ReadandParse.printMatrix(deneme);//for debug
        this.matrix_file_string=this.matrix_file_string+linkedlist.printList();

    }
    public void OutputShapesToFile(String path) {
        linkedlist.MatrixToFile(path,this.matrix_file_string);
    }
}

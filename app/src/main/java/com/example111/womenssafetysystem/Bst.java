package com.example111.womenssafetysystem;

class Node{
    int data;
    String location;
    String publicPlaces;
    String transportation;
    String about;
    Node left;
    Node right;
}

class Bst {

    public static Node createNode(int data,String loc,String places,String transport,String ab) {

        Node newNode=new Node();
        newNode.data=data;
        newNode.location=loc;
        newNode.publicPlaces=places;
        newNode.transportation=transport;
        newNode.about=ab;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
    public static Node insertNode(Node root,int value,String loc,String places,String transport,String ab){
        if(root==null) {
            return createNode(value,loc,places,transport,ab);
        }
        else if(value<root.data) {
            root.left=insertNode(root.left,value,loc,places,transport,ab);
        }
        else {
            root.right=insertNode(root.right,value,loc,places,transport,ab);
        }
        return root;
    }



    public static Node searchNode(Node root,int data) {
        if(root==null) {
            return null;
        }
        else if(data<root.data) {
            root=searchNode(root.left,data);
        }
        else if(data>root.data) {
            root=searchNode(root.right,data);
        }
       else if(root.data==data){
           return root;
        }
       return  root;
    }



}
package com.example.oasis.utils;

import com.example.oasis.po.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SpotTool {


    private ArrayList<SpotItem> spotItemArrayList;




    public void parser(String readpath){
        File inFile = new File(readpath);

          spotItemArrayList=new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            String title = reader.readLine();
            String[] key = title.split(",");
            while (reader.ready()) {
                int n=0;
                String line = reader.readLine();
                String[] datas=line.split(",");

                String[] author_names = datas[1].split(";");
                n=author_names.length;
                ArrayList<Author> authors = new ArrayList<>(n);
                String[] author_affiliations = datas[2].split(";");
                for(int i=0;i<n;i++){
                    Author author=new Author();
                    author.setAuthor_name(author_names[i]);

                    author.setAuthor_affiliations(author_affiliations[i]);
                    author.setFunding_Information("");
                    author.setAuthor_keywords(datas[16]);
                    authors.add(author);
                }

                if(!datas[16].equals("")) {
                    String[] spot_author = datas[16].split(";");
                    for (int i = 0; i < spot_author.length; i++) {
                        for (Author author : authors) {
                            SpotItem spotItem = new SpotItem();
                            spotItem.setSpotname(spot_author[i]);
                            spotItem.setAuthor(author.getAuthor_name().replace('|', ','));
                            spotItem.setOrganization(author.getAuthor_affiliations().replace('|', ','));
                            spotItem.setYear(Integer.valueOf(datas[5]));
                            spotItemArrayList.add(spotItem);
                        }
                    }
                }
                if(!datas[17].equals("")) {
                    String[] spot_IEEE_Terms = datas[17].split(";");
                    for (int i = 0; i < spot_IEEE_Terms.length; i++) {
                        for (Author author : authors) {
                            SpotItem spotItem = new SpotItem();
                            spotItem.setSpotname(spot_IEEE_Terms[i]);
                            spotItem.setAuthor(author.getAuthor_name());
                            spotItem.setOrganization(author.getAuthor_affiliations().replace('|', ','));
                            spotItem.setYear(Integer.valueOf(datas[5]));
                            spotItemArrayList.add(spotItem);
                        }
                    }
                }
                if(!datas[18].equals("")) {
                    String[] spot_INSPEC_Controlled_Terms = datas[18].split(";");
                    for (int i = 0; i < spot_INSPEC_Controlled_Terms.length; i++) {
                        SpotItem spotItem = new SpotItem();
                        spotItem.setSpotname(spot_INSPEC_Controlled_Terms[i]);
                        for (Author author : authors) {
                            spotItem.setAuthor(author.getAuthor_name());
                            spotItem.setOrganization(author.getAuthor_affiliations().replace('|', ','));
                            spotItem.setYear(Integer.valueOf(datas[5]));
                            spotItemArrayList.add(spotItem);
                        }
                    }
                }
                if(!datas[19].equals("")) {
                    String[] spot_INSPEC_Non_Controlled_Terms = datas[19].split(";");
                    for (int i = 0; i < spot_INSPEC_Non_Controlled_Terms.length; i++) {
                        for (Author author : authors) {
                            SpotItem spotItem = new SpotItem();
                            spotItem.setSpotname(spot_INSPEC_Non_Controlled_Terms[i]);
                            spotItem.setAuthor(author.getAuthor_name());
                            spotItem.setOrganization(author.getAuthor_affiliations().replace('|', ','));
                            spotItem.setYear(Integer.valueOf(datas[5]));
                            spotItemArrayList.add(spotItem);
                        }
                    }
                }
                if(!datas[20].equals("")) {
                    String[] spot_Mesh_Terms = datas[20].split(";");
                    for (int i = 0; i < spot_Mesh_Terms.length; i++) {
                        for (Author author : authors) {
                            SpotItem spotItem = new SpotItem();
                            spotItem.setSpotname(spot_Mesh_Terms[i]);
                            spotItem.setAuthor(author.getAuthor_name());
                            spotItem.setOrganization(author.getAuthor_affiliations().replace('|', ','));
                            spotItem.setYear(Integer.valueOf(datas[5]));
                            spotItemArrayList.add(spotItem);
                        }
                    }
                }
                for(SpotItem spotItem:spotItemArrayList){
                    System.out.println(spotItem);
                }



                System.out.println("=====================");



            }
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


    public ArrayList<SpotItem> getSpotItemArrayList() {
        return spotItemArrayList;
    }

    public void setSpotItemArrayList(ArrayList<SpotItem> spotItemArrayList) {
        this.spotItemArrayList = spotItemArrayList;
    }

    public static void main(String[] args){
        new SpotTool().parser("static\\uploadFile\\demo.csv");
    }



}

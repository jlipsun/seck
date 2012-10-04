package com.pcwerk.seck;

import java.io.File;
import java.util.ArrayList;

import com.pcwerk.seck.file.FileSearch;
import com.pcwerk.seck.file.FileWalker;

public class CommandLineSearch 
{
  public static void main(String[] args) {

    if (args.length < 2) {
      System.out.println("usage: CommandLineSearch <path> <search word>");
    }

    String path = args[0];
    String needle = args[1];

    ArrayList<File> fileList = new ArrayList<File>();

    FileWalker fileWalker = new FileWalker();
    fileWalker.walk(path, fileList);

    FileSearch search = new FileSearch();

    for (File haystack : fileList) {
      int count = search.count(needle, haystack);
      if (count > 0)
        System.out.printf("%5d '%s' %s\n", count, needle, haystack.getAbsoluteFile());
    }
  }
}

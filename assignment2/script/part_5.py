#!/bin/python3
import sys
import subprocess
import random
from statistics import mean

def create_random_dataset(ls_data, random_ls_data):

    lines = list()
    written_lines = list()

    with open(ls_data, "r") as f:
        lines = f.readlines()

    with open(random_ls_data, "w") as f:
        count = 0;
        length = len(lines);
        for i in range(length):
            random_data = random.randint(0,length-1-i);
            f.write(lines[random_data])
            lines.pop(random_data)
    print("created a random dataset")

def create_n_files(random_ls_data):

    lines = list()
    with open(random_ls_data, "r") as f:
        lines = f.readlines()

    for i in range(297, 3267, 297):
        with open("../data/random_ls_data_"+str(i)+".txt", "w") as f:
            for j in range(0,i):
                f.write(lines[j]);
    print("created subset files")


def create_parameters(subset_data):
    params=[]
    with open(subset_data, 'r') as f:
        lines = f.readlines()
        for i in lines:
            parameter = (i.split(" ")[0])
            argument = parameter.replace("_", " ")
            params.append(argument)
    return params


def run_LSBSTApp():

    for i in range(297, 3267, 297):
        output_file = "../output/LSBST_output_"+str(i)+".txt"
        input_file = "../data/random_ls_data_"+str(i)+".txt"
        with open(output_file, "w") as f:
            print("Data for subset of data text file for n= "+ str(i))
            parameters = create_parameters(input_file)
            for i in parameters:
                parts = i.split(" ")
                stage = parts[0]
                day = parts[1]
                time = parts[2]
                subprocess.call(["java", "-cp", "../bin", "LSBSTApp", stage, day, time, input_file])

def run_LSAVLTApp():
    for i in range(297, 3267, 297):
        output_file = "../output/LSAVLT_output_"+str(i)+".txt"
        input_file = "../data/random_ls_data_"+str(i)+".txt"
        with open(output_file, "w") as f:
            print("Data for subset of data text file for n= "+ str(i))
            parameters = create_parameters(input_file)
            for i in parameters:
                parts = i.split(" ")
                stage = parts[0]
                day = parts[1]
                time = parts[2]
                subprocess.call(["java", "-cp", "../bin", "LSAVLTApp", stage, day, time, input_file])

def best_average_worst(file_in):
    counts = []
    f =  open(file_in, "r")
    lines = f.readlines()
    for i in lines:
        if i[0] == "S":
            parts = i.split(" ")
            count = parts[2].replace("\n", '')
            counts.append(int(count))
    print("The best case value for search is " + str(min(counts)))
    print("The worst case value for search is " + str(max(counts)))
    print("The average case value for search is " + str(mean(counts)))

if __name__ == "__main__":
    #create_random_dataset("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "../data/random_data.txt");
    #create_n_files("../data/random_data.txt");
    #run_lsbst()
    #run_LSBSTApp()
    #run_LSAVLTApp()
    best_average_worst("../output/LSAVLT_output_2970.txt")
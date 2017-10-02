from operator import attrgetter;
class Contestant:
    def __init__(self,name,submits):
        self.name=name
        self.time=0
        self.submits=submits
        self.solved=0
        self.status=0
    def __repr__(self):
        return str(self.name)
class Submit:
    def __init__(self,time,status):
        self.time=time
        self.status=status
    def __repr__(self):
        return str(self.time)
def findDuration(time):
    x,y=time.split(":")
    return (int(x)*60)+int(y)
def findLimit(list):
    res=0
    for x in list:
        if(x.status==1and x.name>res):
            res=x.name
    return int(res)
def mergeSort(alist):
    if len(alist)>1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)
        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i].solved > righthalf[j].solved:
                alist[k]=lefthalf[i]
                i=i+1
            elif lefthalf[i].solved < righthalf[j].solved:
                alist[k]=righthalf[j]
                j=j+1
            else:
                if lefthalf[i].time < righthalf[j].time:
                    alist[k]=lefthalf[i]
                    i=i+1
                elif lefthalf[i].time > righthalf[j].time:
                    alist[k]=righthalf[j]
                    j=j+1
                else:
                    if lefthalf[i].name< righthalf[j].name:
                        alist[k]=lefthalf[i]
                        i=i+1
                    elif lefthalf[i].name > righthalf[j].name:
                            alist[k]=righthalf[j]
                            j=j+1
            k=k+1

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1
def main():
    n= int(input())
    input()
    for i in range(0,n):
        results=[]
        for h in range(0,25):
            submits={}
            submits["A"]=[]
            submits["B"]=[]
            submits["C"]=[]
            submits["D"]=[]
            submits["E"]=[]
            submits["F"]=[]
            submits["G"]=[]
            results.append(Contestant(h+1, submits))
        line=input()
      
        while line:
            datos=line.split(" ")  
            timeSubmit=findDuration(datos[2])
            numberContestant=int(datos[0])-1
            status=datos[3]
            exercise=datos[1]
            submit= Submit(timeSubmit,status)
            results[numberContestant].status=1
            listSubmit=results[numberContestant].submits[str(exercise)]   
            listSubmit.append(submit)    
            try:
                line=input()    
            except Exception:
                break   
        for conte in results:
            for excer in conte.submits:
                conte.submits[excer]=sorted(conte.submits[excer],key=attrgetter("time","status")) 
                contador=0
                ban=False
                for sub in conte.submits[excer]:
                    if str(sub.status)=="Y" and ban==False :
                        #print(sub.time)
                        conte.time=conte.time+(sub.time+(contador*20))
                        conte.solved=conte.solved+1
                        ban=True
                    contador=contador+1    
        #res=sorted(results,key=key,reverse=True) 
        mergeSort(results)
        print("RANK TEAM PRO/SOLVED TIME")
        limit=findLimit(results)
        contador=1
        solverAux=-1
        timeAux=-1
        ban=False
        for j in range(0,limit):
            if(solverAux!=results[j].solved or timeAux!=results[j].time):
                contador=j+1
                
            if(results[j].solved!=0):    
                ban=True
                print ('{:>4}{:>5}{:>5}{:>11}'.format(contador,results[j].name,results[j].solved,results[j].time))
            else:
                print ('{:>4}{:>5}'.format(contador,results[j].name))
            
            solverAux=results[j].solved
            timeAux=results[j].time  
        if i!=n-1:           
            print()    
if __name__ == '__main__':
    main()
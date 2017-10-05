from math import trunc

class Team:
    def __init__(self,name):
        self.name=name
        self.points=0
        self.num_games=0
        self.gol_a=0
        self.gol_c=0
        self.dif_gol=0
        self.porcent=0
    def goles(self,a,c):
        self.gol_a=self.gol_a+a
        self.gol_c=self.gol_c+c
        self.dif_gol=self.dif_gol+(a-c)
    def calProcent(self):
        if self.num_games==0.0:
            self.porcent="N/A"
        else:    
            self.porcent=str((100*self.points)/(self.num_games*3))
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
            if lefthalf[i].points > righthalf[j].points:
                alist[k]=lefthalf[i]
                i=i+1
            elif lefthalf[i].points < righthalf[j].points:
                alist[k]=righthalf[j]
                j=j+1
            else:
                if lefthalf[i].dif_gol > righthalf[j].dif_gol:
                    alist[k]=lefthalf[i]
                    i=i+1
                elif lefthalf[i].dif_gol < righthalf[j].dif_gol:
                    alist[k]=righthalf[j]
                    j=j+1
                else :
                    if lefthalf[i].gol_a > righthalf[j].gol_a:
                        alist[k]=lefthalf[i]
                        i=i+1
                    elif lefthalf[i].gol_a < righthalf[j].gol_a:
                        alist[k]=righthalf[j]
                        j=j+1
                    else:
                        if lefthalf[i].name.lower() < righthalf[j].name.lower():
                            alist[k]=lefthalf[i]
                            i=i+1
                        elif lefthalf[i].name.lower() > righthalf[j].name.lower():
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
    contador1=0
    while True:
       
        n,g=input().split()
        if(n=="0" and g=="0"):
            break
        teams={}
        for i in range(0,int(n)):
            team=input()
            teams[team]= Team(team)
        for i in range(0,int(g)):
            eq1,gol1,e,gol2,eq2= input().split()
            teams[eq1].num_games=teams[eq1].num_games+1
            teams[eq2].num_games=teams[eq2].num_games+1
            teams[eq1].goles(int(gol1),int(gol2))
            teams[eq2].goles(int(gol2),int(gol1))            
            if int(gol1)>int(gol2):
                teams[eq1].points=teams[eq1].points+3
            elif int(gol1)<int(gol2):
                teams[eq2].points=teams[eq2].points+3
            else:
                teams[eq1].points=teams[eq1].points+1
                teams[eq2].points=teams[eq2].points+1
        clasification=[]
        for te in teams:
            clasification.append(teams[te])
        mergeSort(clasification)  
        contador=1
        auxPoint=-1
        auxDif=-1
        auxGol=-1
        if contador1!=0:
            print() 
        for name in clasification:
            name.calProcent()
            if(name.points!=auxPoint or name.dif_gol!=auxDif or name.gol_a != auxGol):
                if name.porcent=="N/A":
                    print('{:>2}{}{:>16}{:>4}{:>4}{:>4}{:>4}{:>4}{:>4}'.format(contador,".",name.name,str(name.points),str(name.num_games),str(name.gol_a),str(name.gol_c),str(name.dif_gol),"    N/A"))
                else :       
                    oe=float(name.porcent)   
                    print('{:>2}{}{:>16}{:>4}{:>4}{:>4}{:>4}{:>4}{:>7.2f}'.format(contador,".",name.name,str(name.points),str(name.num_games),str(name.gol_a),str(name.gol_c),str(name.dif_gol),oe)) 
            else:
                if name.porcent=="N/A":
                    print('{:>19}{:>4}{:>4}{:>4}{:>4}{:>4}{:>4}'.format(name.name,str(name.points),str(name.num_games),str(name.gol_a),str(name.gol_c),str(name.dif_gol),"    N/A"))
                else :       
                    oe=float(name.porcent)   
                    print('{:>19}{:>4}{:>4}{:>4}{:>4}{:>4}{:>7.2f}'.format(name.name,str(name.points),str(name.num_games),str(name.gol_a),str(name.gol_c),str(name.dif_gol),oe)) 
            contador=contador+1
            auxDif=name.dif_gol
            auxPoint=name.points
            auxGol=name.gol_a
        contador1=2
          
if __name__ == '__main__':
    main()
                        
                 
                 
                       

        
    
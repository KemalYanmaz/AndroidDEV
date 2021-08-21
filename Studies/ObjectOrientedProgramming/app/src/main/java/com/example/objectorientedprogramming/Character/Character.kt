package com.example.objectorientedprogramming.Character

class Character(var name:String,var health:Int,var strength:Int) {
    var bonus:Int = 0
    var isAlive:Boolean = true
    fun attack(enemy: Character){
        if(isAlive){
            if(enemy.isAlive){
                enemy.health-=strength
                println("$name attacked to ${enemy.name}")
                if(enemy.health <= 0){
                    println("${enemy.name} has killed by $name")
                    bonus+=10
                    enemy.isAlive = false
                }else{
                    println("${enemy.name}'s health: ${enemy.health}")
                }
            }else{
                println("Because ${enemy.name} is not alive cannot attack ")
            }
        }
    }

    fun heal(){
        if(isAlive){
            if(bonus>=10){
                bonus-=10
                health+=10
                println("$name healed himself. Health: ${health}")
            }else{
                println("$name does not have enough bonus to heal.")
            }
        }
        else{
            println("${name} is not alive")
        }

    }

    fun combo(enemy: Character){
        for(i in 1..4){
            attack(enemy)
        }
    }
}
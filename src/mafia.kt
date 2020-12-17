import kotlin.random.Random

fun main(){
    var players = Array(10, {player()})
    while (true){
        var maf = players.filter { it.inGame && it.role }.size
        var mir = players.filter { it.inGame }.size - maf
        var dead = players.filter { !it.inGame }.size
        println("Мафии = $maf")
        println("Мирных = $mir")
        println("Убитых = $dead")

        if(mir == 0) break
        if(maf == 0) break

        var playersInGame = players.filter { it.inGame }

        playersInGame.forEach(){it ->
            it.show()
        }
        var mafia = playersInGame.filter { it.role }
        var peaceful = playersInGame.filter { !it.role }


        mafia.forEach{
            var killed = (0..peaceful.size - 1).random()

                    peaceful[killed].inGame = false
        }
    }
}




class player{
    var name = String(Random.Default.nextBytes(4))
    var smart = (0..100).random()
    var role = (0..100).random() < 20
    var inGame = true

    fun show(){
        println("Меня зовут $name, моя хитрость = $smart")
    }

}



A Vito maffia (Vito's family)
=============================
Vito Deadstone, a világszerte ismert gengszter New Yorkba költözött. Ott élt az egész családja, a Lamafia sugárúton. Elhatározta, gyakran látogatja majd rokonait, ezért a közelükben keres házat.

## Feladat:

Vito Minimalizálni akarta a teljes távolságot, ezért megzsarol, hogy írj a problémát megoldó programot.

### Bemenet:

A bemenet néhány tesztesetet tartalmaz. Az első sorban a tesztesetek száma van. Minden tesztesetnél adott a rokonok száma, r (0<r<500), és az s1, s2, ..., sr  rokonok házszámainak sorozata (0<si<30000). Több rokon is lakhat ugyanabban a házban. Lehetséges, hogy a Vito számára optimális házban lakik az egyik rokon is.

### Kimenet:

A kimeneti állományban tesztesetenként meg kell adnod, hogy ideális választás esetén Vito házának mi az össztávolsága () a rokonok házaitól. Két ház távolságát a házszámok különbségének abszolút értékével definiáljuk.

## Példa:

| input.txt | output |
| --------- | ------ |
| 2         |        |
| 2 2 4     | 2      |
| 2 4 6     | 4      |

(ACM Észak-nyugat európai régió 2000)

[Eredeti](https://people.inf.elte.hu/veanna/nevalgimplementalas/01/fa.htm)

-------------------------------------------------------------------------------------------------

## Megoldás

Ha a beolvasott értékeket (címeket) sorba rakjuk, akkor a középen (medián) lévő rokobhoz kell beköltözni.
Minden lépés jobbra 1-et hozzáad a balra lévő rokonokhoz, 1-et csökkent a jobbra lévő rokonokon.
Minden lépés balra fordítva teszi pont ugyanezt. Amint átlépünk egy rokont, többen lesznek az egyik irányba, mint
a másikba, és már nem a minimális összeget fogjuk kapni.

A medián számítási szabálya szerint, ha páros elemszámú adathalmazzal dolgozunk (nincs középső elem), akkor a két 
középső értéket kell venni. Tehát ha összesn __2 családtag__ van, akik a `2`-ben és a `4`-ben laknak, akkor a `3`-ba 
érdemes költözni. Valóban ez a leg igazságosabb (`1`-re lakik mindkettőtől), de a feladat példája a kissebbik címet
várja el outputként. (Amíg nem lépjük át egyik rokont sem, az összeg ugyanaz: `2`, függetlenül attól, hogy 
beköltözünk-e bármelyikhez, vagy a 2 között telepedünk le.)

[A kód](../app/src/main/java/io/github/zebalu/nai/feladat01/Maffia.java)

### Nevezetes algoritmus?

Na jó, de mi itt a nevezetes algoritmus? Az egész közepén a rendezés áll, 
szóval az általam használt [`Arrays.sort(int[])`](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/Arrays.html#sort(int%5B%5D)) tulajdonképpen csalás: nem
én írtam az algoritmust. Amögött egy QuickSort implementáció van, így
készítetetm én is egy [QuickSort](../app/src/main/java/io/github/zebalu/nai/feladat01/QuickSort.java)-ot.
Persze ez nem a dual pivot megoláds, szóval lassabb.

Mivel a feladatban ismert az elemek maximális értéke, akér a [számláló rendezés](../app/src/main/java/io/github/zebalu/nai/feladat01/CountingSort.java) 
is felmerülhet, de az `n` és `k` (rokonok száma kontra lehetséges címek maximuma)
fordított aránya esetén lenne gyorsabb, mint az n*log(n) -es QuickSort.


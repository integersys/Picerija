# Pica Pasūtījumu Sistēma (Java GUI)

Šī ir Java balstīta grafiskā lietotāja interfeisa (GUI) programma, kas simulē picērijas pasūtījumu sistēmu.

### Programmas iespējas:
- [X] Izveidot jaunus pasūtījumus
- [X] Apkalpot nākamos pasūtījumus
- [X] Skatīt aktīvos un pabeigtos pasūtījumus
- [X] Saglabāt pasūtījumus failos un skatīt tos vēlāk
- [X] Izvēlēties picu, piedevas, uzkodas, dzērienus un piegādes veidu
- [X] Aprēķināt gala cenu automātiski
- [X] Sadalīt picas veidošanu metodēs
- [X] Izmantot Java grafiskā interfeisa pamatus
- [X] Spēļu izvēlne
  - [X] FreeRoam (Pats pasūti, pats izveido picu)
  - [ ] Ar klientiem (Klienti saka ko vēlas, tas ir Tavs uzdevums, lai izveidotu pareizo pasūtījumu
- [X] Aktīvie pasūtījumi tiek glabāti **FIFO** rindā (Queue dinamiskajā datu struktūrā)
- [X] Lietotājs var apkalpot tikai nākošo pasūtījumu un atzīmēt to kā pabeigtu
- [X] Pabeigtie pasūtījumi tiek saglabāti ArrayList

## Cenu aprēķins

### Pica:
- **Siera:** 3.50€
- **Pepperoni:** 4.00€
- **Margarita:** 5.00€

### Piedevas:
- **Sēnes:** +2.50€
- **Ananāss:** +0.50€
- **Čili pipari:** +1.50€

### Izmērs:
- **14 collas:** +2.50€
- **16 collas:** +5.00€

### Mērce:
- **Barbekjū / Ķiploku:** +1.50€
- **Šokolādes:** +2.50€

### Uzkodas:
- **Kartupeļi:** +2.00€
- **Siera nūjiņas:** +3.00€
- **Vistas spārniņi:** +4.50€

### Dzērieni:
- **Cola / Fanta:** +2.00€
- **Ūdens:** +1.50€
- **Enerģijas dzēriens:** +3.50€

### Piegāde:
- **+3.00€** ja nav savākts uz vietas

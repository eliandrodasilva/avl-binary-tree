## Definições importantes da AVL Tree

### Altura (h)
A altura de um nó é definida como:
h = 1 + max(altura_esquerda, altura_direita)  
Uma subárvore nula possui altura **-1**.

### Fator de Balanceamento (FB)
O fator de balanceamento de um nó é calculado como:
FB = h(esquerda) - h(direita)

### Condição de Balanceamento
Um nó é considerado balanceado quando:
-1 ≤ FB ≤ 1

## Quando ocorrem desbalanceamentos em uma AVL

Um nó da árvore AVL fica desbalanceado quando seu fator de balanceamento (FB) sai do intervalo permitido:
-1 ≤ FB ≤ 1

Portanto, o desbalanceamento ocorre quando:
- FB = +2 → mais pesado à esquerda  
- FB = -2 → mais pesado à direita  

A partir disso, identificamos qual dos quatro casos aplicar: LL, RR, LR ou RL.

---

## 1. Caso Left-Left (LL) — Rotação Simples à Direita

### Quando ocorre
- Nó desbalanceado está **pesado à esquerda** (FB = +2)  
- Seu **filho à esquerda** também está pesado **à esquerda**  

### Passo a passo da rotação
1. Identifique o **nó desbalanceado** (chamado de `y`).  
2. Pegue o **filho à esquerda** de `y` (chamado de `x`).  
3. O filho **direito** de `x` será temporariamente guardado.  
4. `x` se torna a **nova raiz da subárvore**.  
5. `y` se torna **filho direito de `x`**.  
6. O antigo filho direito de `x` passa a ser o **filho esquerdo de `y`**.  
7. Recalcule as alturas de `x` e `y`.

---

## 2. Caso Right-Right (RR) — Rotação Simples à Esquerda

### Quando ocorre
- Nó desbalanceado está **pesado à direita** (FB = -2)  
- Seu **filho à direita** também está pesado **à direita**

### Passo a passo da rotação
1. Identifique o **nó desbalanceado** (`y`).  
2. Pegue o **filho à direita** de `y` (`x`).  
3. O filho **esquerdo** de `x` é guardado temporariamente.  
4. `x` se torna a **nova raiz da subárvore**.  
5. `y` se torna **filho esquerdo de `x`**.  
6. O antigo filho esquerdo de `x` se torna **filho direito de `y`**.  
7. Recalcule as alturas de `x` e `y`.

---

## 3. Caso Left-Right (LR) — Rotação Dupla à Direita

### Quando ocorre
- Nó desbalanceado está **pesado à esquerda** (FB = +2)  
- O **filho à esquerda** está pesado **à direita**

### Passo a passo da rotação
**Etapa 1 — Rotação simples à esquerda no filho esquerdo**
1. Identifique o nó desbalanceado (`y`) e seu filho esquerdo (`x`).  
2. Pegue o filho direito de `x` (`z`).  
3. `z` assume a posição de filho esquerdo de `y` após as rotações.  
4. O filho esquerdo de `z` vira o novo filho direito de `x`.

**Etapa 2 — Rotação simples à direita no nó desbalanceado**
1. Agora faça uma rotação à direita envolvendo `y` e `z`.  
2. `z` se torna a nova raiz da subárvore.  
3. `x` vira o filho esquerdo de `z`.  
4. `y` vira o filho direito de `z`.  
5. Recalcule as alturas de `x`, `y` e `z`.

---

## 4. Caso Right-Left (RL) — Rotação Dupla à Esquerda

### Quando ocorre
- Nó desbalanceado está **pesado à direita** (FB = -2)  
- O **filho à direita** está pesado **à esquerda**

### Passo a passo da rotação
**Etapa 1 — Rotação simples à direita no filho direito**
1. Identifique o nó desbalanceado (`y`) e seu filho direito (`x`).  
2. Pegue o filho esquerdo de `x` (`z`).  
3. O filho direito de `z` se torna o novo filho esquerdo de `x`.  
4. `z` substitui `x` como filho direito de `y`.

**Etapa 2 — Rotação simples à esquerda no nó desbalanceado**
1. Agora aplique a rotação à esquerda entre `y` e `z`.  
2. `z` se torna a nova raiz da subárvore.  
3. `y` vira seu filho esquerdo.  
4. `x` vira seu filho direito.  
5. Recalcule as alturas de `x`, `y` e `z`.

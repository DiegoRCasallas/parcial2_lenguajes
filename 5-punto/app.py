class AnalizadorDescendente:
    def __init__(self, gramatica):
        self.gramatica = gramatica  # {'S': [['a', 'B'], ['b']], 'B': [['c']]}
        self.first = {}
        self.follow = {}
        self.predict = {}
        self.tokens = []
        self.pos = 0
        
    def calcular_first(self):
        """Calcula conjuntos FIRST para cada símbolo"""
        self.first = {nt: set() for nt in self.gramatica}
        
        cambio = True
        while cambio:
            cambio = False
            for nt, producciones in self.gramatica.items():
                for prod in producciones:
                    for simbolo in prod:
                        if self.es_terminal(simbolo):
                            if simbolo not in self.first[nt]:
                                self.first[nt].add(simbolo)
                                cambio = True
                            break
                        else:
                            antes = len(self.first[nt])
                            self.first[nt] |= self.first[simbolo] - {'ε'}
                            if len(self.first[nt]) > antes:
                                cambio = True
                            if 'ε' not in self.first[simbolo]:
                                break
                    else:
                        if 'ε' not in self.first[nt]:
                            self.first[nt].add('ε')
                            cambio = True
        return self.first
    
    def calcular_follow(self, inicio='S'):
        """Calcula conjuntos FOLLOW para cada no terminal"""
        self.follow = {nt: set() for nt in self.gramatica}
        self.follow[inicio].add('$')
        
        cambio = True
        while cambio:
            cambio = False
            for nt, producciones in self.gramatica.items():
                for prod in producciones:
                    for i, simbolo in enumerate(prod):
                        if not self.es_terminal(simbolo):
                            # Calcular FIRST del resto
                            resto = prod[i+1:]
                            first_resto = self.first_secuencia(resto)
                            
                            antes = len(self.follow[simbolo])
                            self.follow[simbolo] |= first_resto - {'ε'}
                            
                            if 'ε' in first_resto or not resto:
                                self.follow[simbolo] |= self.follow[nt]
                            
                            if len(self.follow[simbolo]) > antes:
                                cambio = True
        return self.follow
    
    def first_secuencia(self, secuencia):
        """Calcula FIRST de una secuencia de símbolos"""
        if not secuencia:
            return {'ε'}
        
        resultado = set()
        for simbolo in secuencia:
            if self.es_terminal(simbolo):
                resultado.add(simbolo)
                return resultado
            else:
                resultado |= self.first[simbolo] - {'ε'}
                if 'ε' not in self.first[simbolo]:
                    return resultado
        resultado.add('ε')
        return resultado
    
    def calcular_predict(self):
        """Calcula conjuntos de predicción para cada producción"""
        self.predict = {}
        for nt, producciones in self.gramatica.items():
            self.predict[nt] = {}
            for i, prod in enumerate(producciones):
                first_prod = self.first_secuencia(prod)
                pred = first_prod - {'ε'}
                if 'ε' in first_prod:
                    pred |= self.follow[nt]
                self.predict[nt][i] = pred
        return self.predict
    
    def es_terminal(self, simbolo):
        """Verifica si un símbolo es terminal"""
        return simbolo not in self.gramatica and simbolo != 'ε'
    


    def emparejar(self, esperado):
        """Función de emparejamiento (match)
        
        Args:
            esperado: Token esperado en la posición actual
            
        Returns:
            bool: True si hubo emparejamiento exitoso
            
        Raises:
            SyntaxError: Si no hay coincidencia entre el token esperado y el actual
        """
        # Obtener el token actual
        actual = self.tokens[self.pos] if self.pos < len(self.tokens) else '$'
        
        # Verificar si hay coincidencia
        if actual == esperado:
            print(f"✓ Emparejado: {esperado}")
            self.pos += 1
            return True
            
        # Si no hay coincidencia, lanzar error
        error_msg = f"Error: Se esperaba '{esperado}', se encontró '{actual}'"
        raise SyntaxError(error_msg)
    


    
    
    def parsear(self, no_terminal):
        """Análisis descendente recursivo"""
        print(f"\nAnalizando: {no_terminal}")
        actual = self.tokens[self.pos] if self.pos < len(self.tokens) else '$'
        
        # Buscar producción usando conjuntos de predicción
        prod_idx = None
        for i, pred in self.predict[no_terminal].items():
            if actual in pred:
                prod_idx = i
                break
        
        if prod_idx is None:
            raise SyntaxError(f"Error: No hay producción para {no_terminal} con token '{actual}'")
        
        produccion = self.gramatica[no_terminal][prod_idx]
        print(f"Usando: {no_terminal} → {' '.join(produccion)}")
        
        for simbolo in produccion:
            if simbolo == 'ε':
                continue
            elif self.es_terminal(simbolo):
                self.emparejar(simbolo)
            else:
                self.parsear(simbolo)
    
    def analizar(self, entrada, inicio='S'):
        """Ejecuta el análisis completo"""
        self.tokens = list(entrada) + ['$']
        self.pos = 0
        
        print("=" * 50)
        print("ANÁLISIS SINTÁCTICO DESCENDENTE RECURSIVO")
        print("=" * 50)
        
        try:
            self.parsear(inicio)
            if self.pos == len(self.tokens):
                print("\n✓ ANÁLISIS EXITOSO")
                return True
        except SyntaxError as e:
            print(f"\n✗ {e}")
            return False


# Ejemplo de uso
if __name__ == "__main__":
    # Gramática: S → aB | b
    #            B → c | d
    gramatica = {
        'S': [['a', 'B'], ['b']],
        'B': [['c'], ['d']]
    }
    
    analizador = AnalizadorDescendente(gramatica)
    
    # Cálculo de conjuntos
    print("CONJUNTOS FIRST:")
    first = analizador.calcular_first()
    for nt, f in first.items():
        print(f"  FIRST({nt}) = {f}")
    
    print("\nCONJUNTOS FOLLOW:")
    follow = analizador.calcular_follow()
    for nt, f in follow.items():
        print(f"  FOLLOW({nt}) = {f}")
    
    print("\nCONJUNTOS DE PREDICCIÓN:")
    predict = analizador.calcular_predict()
    for nt, prods in predict.items():
        for i, pred in prods.items():
            prod_str = ' '.join(gramatica[nt][i])
            print(f"  PREDICT({nt} → {prod_str}) = {pred}")
    
    # Pruebas
    print("\n" + "=" * 50)
    analizador.analizar("ac")
    
    print("\n" + "=" * 50)
    analizador.analizar("b")
    
    print("\n" + "=" * 50)
    analizador.analizar("ad")
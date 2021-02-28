class HashTableFunctions
{
   int hashTableSize;
   String [] hashTableArray;
   
   // constructor
   public HashTableFunctions ( int size, String [] array )
   {
      hashTableSize = size;
      hashTableArray = array;
   }

   // hash function
   public int hash ( String s )
   {
      int g = 31;
      int hashVal = 0;
      for( int i = 0; i < s.length(); i++ )
         hashVal = (g * hashVal) + s.charAt(i);
         hashVal = hashVal & 0X7FFFFFFF;
      return hashVal % hashTableSize;
   }

   // return True if the hash table contains string s
   // return False if the hash table does not contain string s
   boolean find ( String s )
   {
      boolean found = false;
      int query = hash(s);
      for (int i = 0; i < hashTableSize; i++){
         if (hashTableArray[i] == s)
            return found = true;}
      return found;
   }
}

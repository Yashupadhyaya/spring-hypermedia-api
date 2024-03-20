// ********RoostGPT********
/*
Test generated by RoostGPT for test psring-hypermedia using AI Type Azure Open AI and AI Model roostgpt-4-32k

ROOST_METHOD_HASH=getBooks_7326b6767f
ROOST_METHOD_SIG_HASH=getBooks_9722ce6c80

================================VULNERABILITIES================================
Vulnerability: Information Disclosure
Issue: The getBooks() method reveals the internal state of the object, which could potentially be manipulated by malicious clients.
Solution: Return a copy of the books, not the books themselves. By returning a copy, the original data is safe from manipulation.

Vulnerability: Immutable Objects
Issue: If the Book class is mutable, and the reference to the Book object is being passed around in the code, its fields can be altered.
Solution: Ensure that the Book class is immutable by making all its fields final and providing no setter methods.

Vulnerability: Unchecked Exceptions
Issue: Unchecked exceptions in the application can cause it to crash.
Solution: Wrap the body of the methods in a try-catch block and handle exceptions appropriately.

================================================================================
Scenario 1: Test to check if the method returns an empty list when no books are added

Details:  
  TestName: testGetBooksWhenEmpty
  Description: This test checks if the getBooks method returns an empty list when no books have been added to it.
Execution:
  Arrange: No books are added to the books list.
  Act: Invoke the getBooks method.
  Assert: Assert that the returned list is empty.
Validation: 
  The assertion verifies if the method behaves as expected when it's called without any books being added. This is important as it's a valid situation that could occur in the application and should be handled correctly.

Scenario 2: Test to check if the method returns the correct books when books are added

Details:  
  TestName: testGetBooksWhenBooksAreAdded
  Description: This test checks if the getBooks method returns the correct list of books when books have been added.
Execution:
  Arrange: Add books to the books list.
  Act: Invoke the getBooks method.
  Assert: Assert that the returned list is equal to the list of books added.
Validation: 
  The assertion verifies if the method returns the correct list of books when books have been added. This test ensures the basic functionality of the getBooks method.

Scenario 3: Test for concurrent modification while getting books when books are added

Details:  
  TestName: testGetBooksForConcurrentModification
  Description: This test is meant to check the scenario where books list might get modified concurrently while fetching the list.
Execution:
  Arrange: Add books to the books list and modify the list while fetching.
  Act: Invoke the getBooks method.
  Assert: Check for the ConcurrentModificationException and handle it.
Validation: 
  The assertion here aims to verify if the method behaves as expected when the underlying list is concurrently modified. The significance of this test is to ensure the method can handle a possible concurrency issue.
  
Scenario 4: Test method's response to null values in the list

Details:  
  TestName: testGetBooksWithNullValues
  Description: This test is designed to check how the method responds when there are null values in the list of books.
Execution:
  Arrange: Add null values to the books list.
  Act: Invoke the getBooks method.
  Assert: Verify that the returned list contains null values.
Validation: 
  This test measures the method's ability to handle null values. This is a valid situation that could occur and should be handled correctly.
  
Scenario 5: Test to check the order of return books

Details:  
  TestName: testGetBooksReturnsInCorrectOrder
  Description: The purpose of this test is to confirm that the method is returning books in the correct order.
Execution:
  Arrange: Add books to the books list in a specified order.
  Act: Invoke the getBooks method.
  Assert: Assert that the order of the returned list is same as the order of books added.
Validation: 
   This test is essential as it ensures that the getBooks method maintains the order of the books when they are added. This could be important in certain use-cases where the order of books is significant.
*/

// ********RoostGPT********
@Test
public void testGetBooksReturnsUnmodifiableList() {
    cart.add(book1);
    cart.add(book2);
    List<Book> books = cart.getBooks();
    assertThrows(UnsupportedOperationException.class, () -> books.add(book1));
    assertThrows(UnsupportedOperationException.class, () -> books.remove(0));
}

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="bg-gray-50 dark:bg-gray-900">
  <div
    class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
    <div
      class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
      <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
        <h1
          class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
          Reset password</h1>
          <c:if test="${error != null }">
                <span class="mt-2 text-red-600">${error }</span>
              </c:if>
        <form class="space-y-4 md:space-y-6" method="post">
          <input type="hidden" name="token" value="${token}">
          <div>
            <label for="password"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
              New password</label> <input type="password" name="password" id="password"
              class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="********" required>
          </div>
          <div>
            <label for="confirmPassword"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
              Confirm password</label> <input type="password" name="confirmPassword" id="confirmPassword"
              class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="********" required>
          </div>
          <button type="submit"
            class="w-full text-white bg-gray-600 hover:bg-gray-400 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
            Continue
            </button>
        </form>
      </div>
    </div>
  </div>
</section>
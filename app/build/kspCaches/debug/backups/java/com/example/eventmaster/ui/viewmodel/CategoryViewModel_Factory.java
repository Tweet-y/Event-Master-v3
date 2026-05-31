package com.example.eventmaster.ui.viewmodel;

import com.example.eventmaster.data.repository.CategoryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class CategoryViewModel_Factory implements Factory<CategoryViewModel> {
  private final Provider<CategoryRepository> repositoryProvider;

  public CategoryViewModel_Factory(Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CategoryViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static CategoryViewModel_Factory create(
      javax.inject.Provider<CategoryRepository> repositoryProvider) {
    return new CategoryViewModel_Factory(Providers.asDaggerProvider(repositoryProvider));
  }

  public static CategoryViewModel_Factory create(Provider<CategoryRepository> repositoryProvider) {
    return new CategoryViewModel_Factory(repositoryProvider);
  }

  public static CategoryViewModel newInstance(CategoryRepository repository) {
    return new CategoryViewModel(repository);
  }
}
